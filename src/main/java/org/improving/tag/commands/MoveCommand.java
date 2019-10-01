package org.improving.tag.commands;

import org.improving.tag.Exit;
import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MoveCommand extends BaseAliasedCommand {
    private InputOutput io;

    public MoveCommand(InputOutput io) {
        super(io,"move", "m", "mo", "mov");
        this.io = io;
    }

    @Override
    public String getCommandPart(String input) {
        var parts = input.split(" ");
        if (parts.length == 1) throw new UnsupportedOperationException();
        return parts[0];
    }

    @Override
    public String getErrorMessage() {
        return "I can't find that way out.";
    }

    @Override
    public void childExecute(String input, Game game) {
        var parts = input.trim().split(" ");

        // SOLVE with substring
//        var destination = input.substring(input.indexOf(" ") + 1);

        // SOLVE by copying the Array
//        var parameters = Arrays.asList(parts);
//        parameters.remove(0);
//        var destinationTim = String.join(" ", parameters);

        // SOLVE by copying array from range until length
        var path = Arrays.copyOfRange(parts, 1, parts.length);
        var destination = String.join(" ", path);

        Exit exit = null;
        for (var e : game.getPlayer().getLocation().getExits()) {
            if (e.getName().equalsIgnoreCase(destination)) {
                exit = e;
            } else {
                for (var a : e.getAliases()) {
                    if (a.equalsIgnoreCase(destination)) {
                        exit = e;
                        break;
                    }
                }
            }
            if (exit != null) break;
        }
        if (exit == null) throw new UnsupportedOperationException();
        if (game.getPlayer().getLocation().getAdversary() != null) {
            io.displayText("YOU SHALL NOT PASS.");
            return;
        }
        game.getPlayer().setLocation(exit.getDestination());
        io.displayText("You travel " + exit.getName() + ".");
    }
}
