package CodexVI.core;

import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CodexCommit {
    public void commit() {
        File index = new File(".codexvi/index");
        if (!index.exists() || index.length() == 0) {
            System.out.println("Nothing to commit. Add files first.");
            return;
        }

        try {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File commitDir = new File(".codexvi/commits/commit_" + timestamp);
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

            System.out.println("Commit saved as " + commitDir.getName());
        } catch (Exception e) {
            System.out.println("Error committing: " + e.getMessage());
        }
    }
}
