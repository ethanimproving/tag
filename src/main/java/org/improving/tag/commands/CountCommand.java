package org.improving.tag.commands;

import org.improving.tag.Game;
import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class CountCommand implements Command {
    private InputOutput io;
    int count = 0;

    public CountCommand(InputOutput io) {
        this.io = io;
    }

    @Override
    public boolean isValid(String input, Game game) {
        return (input == null ? "" : input).trim().equalsIgnoreCase("count");
    }

    @Override
    public void execute(String input, Game game) {
        count++;
        io.displayText("You have called the count command " + count + " time" + (count < 2 ? "" : "s"));
    }
}
