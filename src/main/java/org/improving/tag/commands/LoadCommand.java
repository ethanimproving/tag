package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.SaveGameFactory;
import org.springframework.stereotype.Component;

@Component
public class LoadCommand implements Command {

    private final SaveGameFactory saveFactory;

    public LoadCommand(SaveGameFactory saveFactory) {
        this.saveFactory = saveFactory;
    }

    @Override
    public boolean isValid(String input, Game game) {
        if (input == null) return false;
        input = input.trim();
        var parts = input.split(" ");
        if (parts.length == 1) return false;
        return parts[0].equalsIgnoreCase("load");
    }

    @Override
    public void execute(String input, Game game) {
        input = input.trim();
        String filePath = input.substring(5);
        saveFactory.load(filePath, game);
    }
}
