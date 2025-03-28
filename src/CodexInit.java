package CodexIV;

import java.io.File;
import java.io.IOException;

public class CodexInit {
    public void initRepo() {
        File vcsDir = new File(".myvcs");
        File indexFile = new File(".codexiv/index");
        File commitsDir = new File(".codexiv/commits");
        File branchesFile = new File(".codexiv/branches");
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
