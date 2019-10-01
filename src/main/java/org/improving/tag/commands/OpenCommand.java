package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class OpenCommand extends BaseAliasedCommand {
    public OpenCommand(InputOutput io, String... aliases) {
        super(io, "open", "open treasure", "o");
    }

    @Override
    public void childExecute(String input, Game game) {
        var item = game.getPlayer().getLocation().openTreasureChest();

        io.displayText("You found: " + item +
                "\nTreasure Description: " + item);
        game.getPlayer().getInventory().addItem(item);
    }

    @Override
    public String getErrorMessage() {
        return "Are you seeing things? There's no treasure here!";
    }
}
