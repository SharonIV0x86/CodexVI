package CodexVI;

import java.io.File;
import java.io.IOException;

public class CodexInit {
    public void initRepo() {
        File vcsDir = new File(".codexvi");
        File indexFile = new File(".codexvi/index");
        File commitsDir = new File(".codexvi/commits");
        File branchesFile = new File(".codexvi/branches");
        if (vcsDir.exists()) {
            System.out.println("Repository already initialized.");
            return;
        }

        if (vcsDir.mkdir() && commitsDir.mkdir()) {
            try {
                indexFile.createNewFile();
                branchesFile.createNewFile();
                System.out.println("Initialized an empty repository in " + vcsDir.getAbsolutePath());
            } catch (IOException e) {
                System.out.println("Error initializing repository: " + e.getMessage());
            }
        }
    }

}
