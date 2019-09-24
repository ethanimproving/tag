package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class LookCommand implements Command {
    private InputOutput io;

    public LookCommand(InputOutput io) {
        this.io = io;
//        super("look", "You look around.", io);
    }

    @Override
    public boolean isValid(String input, Game game) {
        return input.trim().equalsIgnoreCase("look") ||
                input.trim().equalsIgnoreCase("whereami") ||
                input.trim().equalsIgnoreCase("where am i") ||
                input.trim().equalsIgnoreCase("donde estoy") ||
                input.trim().equalsIgnoreCase("?donde estoy?");
    }

    @Override
    public void execute(String input, Game game) {
        var location = game.getPlayer().getLocation();
        io.displayText(location.getName());
        io.displayText(location.getDescription());
        io.displayText("");
        io.displayText("Exits:");
        for ( var exit : location.getExits()) {
            io.displayText("  " + exit.getName());
        }

    }
}
