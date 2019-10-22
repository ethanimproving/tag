package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.improving.tag.TreasureChest;
import org.improving.tag.database.ExitRepository;
import org.springframework.stereotype.Component;

@Component
public class LookCommand extends BaseAliasedCommand {
    private InputOutput io;
    private ExitRepository exitRepository;

    public LookCommand(InputOutput io, ExitRepository exitRepository) {
        super(io,"l", "look", "whereami", "where am i", "donde estoy", "?donde estoy?");
        this.io = io;
        this.exitRepository = exitRepository;
    }

    @Override
    public void execute(String input, Game game) {
        var location = game.getPlayer().getLocation();
        io.displayText(location.getName() + ": " + location.getDescription());
        io.displayNewLine();

        if(location.getTreasureChest() != TreasureChest.NO_TREASURE) {
            io.displayText("Treasure:");
            io.displayText("  " + location.getTreasureChest());
            io.displayNewLine();
        }


        io.displayText("Exits:");
        exitRepository.findExitsByOriginId(location.getId())
                .forEach(e -> System.out.println("  " + e.getName()));

        if(location.getAdversary() != null) {
            io.displayNewLine();
            io.displayText("Watch out! " + location.getAdversary().getName() + " is right behind you!");
        }

    }
}
