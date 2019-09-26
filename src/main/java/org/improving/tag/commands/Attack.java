package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Attack implements Command {

    InputOutput io;

    public Attack(InputOutput io) {
        this.io = io;
    }

    @Override
    public boolean isValid(String input, Game game) {
        return (input == null ? "" : input).trim().equalsIgnoreCase("attack");
    }

    @Override
    public void execute(String input, Game game) {
        var adversary = game.getPlayer().getLocation().getAdversary();
        if (adversary == null) {
            io.displayText("Attack what?");
        } else {
            int random = new Random().nextInt(100);
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
