package org.improving.tag.commands;

import org.improving.tag.InputOutput;

public class PunchCommand extends BaseEmoteCommand {
    public PunchCommand(InputOutput io) {
        super("punch", "You have been ninja punched! FATALITY.", io);
    }
}
