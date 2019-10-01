package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.GameExitException;
import org.improving.tag.InputOutput;
import org.improving.tag.SaveGameFactory;
import org.springframework.stereotype.Component;

@Component
public class ExitCommand extends BaseAliasedCommand {
    private final SaveGameFactory saveFactory;

    // Spring will assign a new SaveGameFactory to this.saveFactory for us.
    public ExitCommand(SaveGameFactory saveFactory, InputOutput io) {
        super(io, "exit");
        this.saveFactory = saveFactory;
    }

    public String getErrorMessage() {
        return "Well, leave then...";
    }

    @Override
    public void childExecute(String input, Game game) {
        saveFactory.save(game);
        throw new GameExitException();
    }
}
