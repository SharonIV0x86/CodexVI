package CodexVI;

import CodexVI.commands.CodexInitCommand;
import CodexVI.commands.CodexAddCommand;
import CodexVI.commands.CodexCommitCommand;

import java.util.HashMap;
import java.util.Map;

public class CodexVI {
    private final Map<String, CodexCommander> commands = new HashMap<>();

    public CodexVI() {
        commands.put("init", new CodexInitCommand());
        commands.put("add", new CodexAddCommand());
        commands.put("commit", new CodexCommitCommand());
    }

    public void executeCommand(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java CodexVI <command> [arguments]");
            return;
        }

        CodexCommander command = commands.get(args[0].toLowerCase());
        if (command != null) {
            command.execute(args);
        } else {
            System.out.println("Unknown command: " + args[0]);
        }
    }

    public static void main(String[] args) {
        new CodexVI().executeCommand(args);
    }
}
