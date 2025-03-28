package CodexIV;

import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CodexCommit {
    public void commit() {
        File index = new File(".codexiv/index");
        if (!index.exists() || index.length() == 0) {
            System.out.println("Nothing to commit. Add files first.");
            return;
        }

        try {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File commitDir = new File(".codexiv/commits/commit_" + timestamp);
            commitDir.mkdir();

            BufferedReader reader = new BufferedReader(new FileReader(index));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String filePath = parts[0];

                Path src = Paths.get(filePath);
                Path dest = Paths.get(commitDir.getPath(), new File(filePath).getName());

                Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING);
            }
            reader.close();

            new PrintWriter(index).close(); 

            File log = new File(".codexiv/log.txt");
            FileWriter logWriter = new FileWriter(log, true);
            logWriter.write("Commit: " + timestamp + "\n");
            logWriter.close();

            System.out.println("Commit saved as " + commitDir.getName());
        } catch (Exception e) {
            System.out.println("Error committing: " + e.getMessage());
        }
    }
    public void showLog() {
        File log = new File(".codexiv/log.txt");
        if (!log.exists()) {
            System.out.println("No commits found.");
            return;
        }
    
        try (BufferedReader reader = new BufferedReader(new FileReader(log))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading log: " + e.getMessage());
        }
    }
    
}
