package CodexVI.commands;

import CodexVI.CodexCommander;
import CodexVI.core.CodexInit;

public class CodexInitCommand implements CodexCommander {
    private final CodexInit codexInit = new CodexInit();

    @Override
    public void execute(String[] args) {
        String branchName = "main";  // Default branch

        if (args.length > 1) {
            if (args[1].contains(".")) {
                System.out.println("Branch names cannot contain (.)");
                return;
            }
            branchName = args[1];
        }

        codexInit.initRepo(branchName);
    }
}
