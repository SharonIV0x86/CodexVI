package CodexVI;

public class CodexVI {
    CodexAdd codexAdd;
    CodexInit codexInit;
    CodexCommit codexCommit;

    public CodexVI() {
        codexInit = new CodexInit();
        codexAdd = new CodexAdd();
        codexCommit = new CodexCommit();
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java CodexVI <command> [arguments]");
            return;
        }

        CodexVI codex = new CodexVI();
        
        switch (args[0].toLowerCase()) {
            case "init":
                codex.codexInit.initRepo();
                break;
            case "add":
                if (args.length < 2) {
                    System.out.println("Usage: java CodexVI add <file-path>");
                    return;
                }
                codex.codexAdd.addFile(args[1]);
                break;
            case "commit":
                codex.codexCommit.commit();
                break;
            default:
                System.out.println("Unknown command: " + args[0]);
        }
    }
}
