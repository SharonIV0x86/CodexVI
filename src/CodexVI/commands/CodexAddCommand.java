package CodexVI.commands;

import CodexVI.CodexCommander;
import CodexVI.core.CodexAdd;
public class CodexAddCommand implements CodexCommander {
    private final CodexAdd codexAdd = new CodexAdd();

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java CodexVI add <file-path>");
            return;
        }
        codexAdd.addFile(args[1]);
    }
}
