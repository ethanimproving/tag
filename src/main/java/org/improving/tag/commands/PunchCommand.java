package org.improving.tag.commands;

import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class PunchCommand extends BaseEmoteCommand {
    public PunchCommand(InputOutput io) {
        super("punch", "You have been ninja punched! FATALITY.", io);
    }
}
