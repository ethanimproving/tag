package org.improving.tag.commands;

import org.improving.tag.Exit;
import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.database.ExitRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MoveCommand extends BaseAliasedCommand {
    private InputOutput io;
    private ExitRepository exitRepository;


    public MoveCommand(InputOutput io, ExitRepository exitRepository) {
        super(io,"move", "m", "mo", "mov");
        this.io = io;
        this.exitRepository = exitRepository;
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

        // SOLVE by copying array from range until length
        var path = Arrays.copyOfRange(parts, 1, parts.length);
        var destination = String.join(" ", path);

        List<Exit> locationExits = new ArrayList<>(exitRepository.findExitsByOriginId(game.getPlayer().getLocation().getId()));

        Exit exit = locationExits.stream()
                .filter(e -> e.getAliases().stream().anyMatch(destination::equalsIgnoreCase))
                .findFirst()
                .orElse(null);

        if (exit == null) throw new UnsupportedOperationException();
        if (game.getPlayer().getLocation().getAdversary() != null) {
            io.displayText("YOU SHALL NOT PASS.");
            return;
        }
        game.getPlayer().setLocation(exit.getDestination());
        io.displayText("You travel " + exit.getName() + ".");
    }
}
