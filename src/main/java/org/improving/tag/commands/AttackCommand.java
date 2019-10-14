package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AttackCommand extends BaseAliasedCommand {

    private final Random r;
    InputOutput io;

    public AttackCommand(InputOutput io, Random r) {
        super(io,"attack", "a", "mock");
        this.io = io;
        this.r = r;
    }

    @Override
    public void execute(String input, Game game) {
        var adversary = game.getPlayer().getLocation().getAdversary();
        if (adversary == null) {
            io.displayText("Attack what?");
        } else {
            int random = r.nextInt(100) + 1;
            if (random <= 50) {
                adversary.setDamageTaken(adversary.getDamageTaken() + 10);
                adversary.setHitPoints(100 - adversary.getDamageTaken());
                io.displayText(adversary.getName() + "'s Remaining Health: " + adversary.getHitPoints());
            } else {
                io.displayText("Attack Missed!");
            }
            if (adversary.getHitPoints() <= 0) {
                var advItem = adversary.getInventory().getItem();

                io.displayText("You have defeated " + adversary.getName() + ". " + advItem + " was found on his dead corpse. #winning");
                game.getPlayer().getInventory().addItem(advItem);
                game.getPlayer().getLocation().setAdversary(null);
            }
        }
    }
}
