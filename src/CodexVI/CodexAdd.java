package CodexVI;

import java.io.*;
import java.nio.file.*;
import java.security.*;

public class CodexAdd {
    public  String computeSHA1(String filePath) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));
        byte[] hashBytes = digest.digest(fileBytes);
        
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }

    public  void addFile(String filePath) {
        
        File index = new File(".codexvi/index");
        if (!index.exists()) {
            System.out.println("Repository not initialized. Run `myvcs init` first.");
            return;
        }

        try {
            String hash = computeSHA1(filePath);
            FileWriter writer = new FileWriter(index, true);
            writer.write(filePath + " " + hash + "\n");
            writer.close();
            System.out.println("Added: " + filePath);
        } catch (Exception e) {
            System.out.println("Error adding file: " + e.getMessage());
        }
    }

}
