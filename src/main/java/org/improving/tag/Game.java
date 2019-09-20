package org.improving.tag;

import org.improving.tag.commands.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Game {
    private Date startTime;
    private Date endTime;
    private Command[] commands;
    private InputOutput io;


    public Game(Command[] commands, InputOutput io) {
        this.commands = commands;
        this.io = io;
    }

    public Date getStartTime() {
        return startTime;
    }

    private void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    private void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void run() {
        this.setStartTime(new Date());

        boolean loop = true;

        do {
            io.displayPrompt("> ");
            String input = io.receiveInput();
            Command validCommand = getValidCommand(input);

            if (null != validCommand) {
                validCommand.execute(input);
            } else if (input.equalsIgnoreCase("exit")) {
                io.displayText("Well, leave then...");
                loop = false;
            } else {
                io.displayText("Huh? I don't understand.");
            }
        } while (loop);
        this.setEndTime(new Date());
    }

    private Command getValidCommand(String input) {
        for (Command command : commands) {
            if (command.isValid(input)) {
                return command;
            }
        }
        return null;
    }

}
