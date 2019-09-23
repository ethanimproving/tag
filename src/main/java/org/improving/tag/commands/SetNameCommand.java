package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class SetNameCommand implements Command {

    @Override
    public boolean isValid(String input, Game game) {

        if (input == null) return false;
        if (!input.contains("=")) return false;
        input = input.trim();
        var parts = input.split("=");
        if (parts.length == 1) return false;
        return parts[0].equalsIgnoreCase("@set name");
    }

    @Override
    public void execute(String input, Game game) {
        input = input.trim();
        var parts = input.split("=");
        game.getPlayer().setName(parts[1]);
    }
}
