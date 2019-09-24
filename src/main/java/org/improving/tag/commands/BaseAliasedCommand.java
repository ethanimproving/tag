package org.improving.tag.commands;

import org.improving.tag.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class BaseAliasedCommand implements Command {
    private List<String> aliases = new ArrayList<>();

    @Override
    public boolean isValid(String input, Game game) {
        return aliases.stream()
                .filter(input::equalsIgnoreCase).findFirst().isPresent();
    }
}
