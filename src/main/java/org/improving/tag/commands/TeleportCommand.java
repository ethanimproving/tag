package org.improving.tag.commands;

import org.springframework.stereotype.Component;

@Component
public class TeleportCommand extends BaseEmoteCommand {
    public TeleportCommand() {
        super("teleport", "You phase out of existence.");
    }
}
