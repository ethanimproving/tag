package org.improving.tag.commands;

import org.improving.tag.InputOutput;

public class KickCommand extends BaseEmoteCommand {
    public KickCommand(InputOutput io) {
        super("kick", "You have been ninja kicked! FATALITY.", io);
    }
}
