package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class SetNameCommand implements Command {

    @Override
    public boolean isValid(String input, Game game) {

//        if (input == null) return false;
//        input = input.trim();
//        var parts = input.split(" ");
//        if (parts.length == 1) return false;
//        return parts[0].equalsIgnoreCase("@set");

        if (input == null) return false;
        if (input.length() < 11) return false;
        return input.trim().startsWith("@set name=");
    }

    @Override
    public void execute(String input, Game game) {
        input = input.trim();
        var name = input.substring(10).trim();
        game.getPlayer().setName(name);
    }
}
