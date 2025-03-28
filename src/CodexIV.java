package CodexIV;

public class CodexIV {
    CodexAdd codexAdd;
    CodexInit codexInit;
    CodexCommit codexCommit;

    public CodexIV() {
        codexInit = new CodexInit();
        codexAdd = new CodexAdd();
        codexCommit = new CodexCommit();
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java CodexIV <command> [arguments]");
            return;
        }

        CodexIV codex = new CodexIV();
        
        switch (args[0].toLowerCase()) {
            case "init":
                codex.codexInit.initRepo();
                break;
            case "add":
                if (args.length < 2) {
                    System.out.println("Usage: java CodexIV add <file-path>");
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
