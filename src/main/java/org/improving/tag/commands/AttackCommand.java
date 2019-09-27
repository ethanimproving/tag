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
        super("attack", "a", "mock");
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
            if (random <= 20) {
                adversary.setDamageTaken(adversary.getDamageTaken() + 10);
                adversary.setHitPoints(adversary.getMaxHitPoints() - adversary.getDamageTaken());
                io.displayText(adversary.getName() + "'s Remaining Health: " + adversary.getHitPoints());
            } else {
                io.displayText("Attack Missed!");
            }
        }
    }
}
