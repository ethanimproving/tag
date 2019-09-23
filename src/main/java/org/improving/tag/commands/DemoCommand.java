package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class DemoCommand implements Command {
    // Constants are final after constructors.
    private final InputOutput io;
    private int ingCount = 0;

    public DemoCommand(InputOutput io) {
        this.io = io;
    }

    @Override
    public boolean isValid(String input, Game game) {
        return input.trim().endsWith("ing");
    }

    @Override
    public void execute(String input, Game game) {
        ingCount++;
        io.displayText("We have 'ing'ed " + ingCount + " times.");
    }
}
