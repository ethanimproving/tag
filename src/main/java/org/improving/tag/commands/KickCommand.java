package org.improving.tag.commands;

import org.improving.tag.InputOutput;
import org.springframework.stereotype.Component;

@Component
public class KickCommand extends BaseEmoteCommand {
    public KickCommand(InputOutput io) {
        super("kick", "You have been ninja kicked! FATALITY.", io);
    }
}
