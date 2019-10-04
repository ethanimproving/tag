package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CuddleCommand extends BaseAliasedCommand {
    private Random r;
    private ExitCommand exit;

    public CuddleCommand(InputOutput io, Random r, ExitCommand exit, String... aliases) {
        super(io, "cuddle", "c");
        this.r = r;
        this.exit = exit;
    }

    @Override
    public void execute(String input, Game game) {

        var adversary = game.getPlayer().getLocation().getAdversary();

        if (adversary == null) {
            io.displayText("You just cuddled a sweet potato. Both of your parents are ashamed. -15 hit points.");
        } else {
            var cuddleBuddy = adversary.getName();

            int random = r.nextInt(100) + 1;
            if (random <= 50) {
                io.displayText("You tried cuddling " + cuddleBuddy + ". He stabbed you while you were fondling " + "his left ear lobe. GAME OVER.");
                exit.execute("exit", game);
            } else {
                var advItem = adversary.getInventory().getItem();
                io.displayText("You have cuddled " + cuddleBuddy + ". He is now an ally and has given you a " + advItem + ".");
                game.getPlayer().getInventory().addItem(advItem);
                game.getPlayer().getLocation().setAdversary(null);
            }
        }

    }
}
