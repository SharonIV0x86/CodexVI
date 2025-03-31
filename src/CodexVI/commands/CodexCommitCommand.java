package CodexVI.commands;

import CodexVI.CodexCommander;
import CodexVI.core.CodexCommit;

public class CodexCommitCommand implements CodexCommander {
    private final CodexCommit codexCommit = new CodexCommit();

    @Override
    public void execute(String[] args) {
        codexCommit.commit();
    }
}
