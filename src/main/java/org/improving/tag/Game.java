package org.improving.tag;

import org.improving.tag.commands.Command;
import org.improving.tag.domain.Location;
import org.improving.tag.domain.Player;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Component
public class Game {
    private Date startTime;
    private Date endTime;
    private Command[] commands;
    private InputOutput io;
    private Player p;
    private Location startingLocation;
    private List<Location> locationList = new ArrayList<>();
    public final SaveGameFactory saveFactory;


    // Spring component is inserting the arguments for this constructor itself.
    public Game(Command[] commands, InputOutput io, SaveGameFactory saveFactory, WorldBuilder worldBuilder) {
        this.startingLocation = worldBuilder.buildWorld();
        this.commands = commands;
        this.io = io;
        this.p = new Player(startingLocation);
        this.saveFactory = saveFactory;
    }

    public Location getStartingLocation() {
        return startingLocation;
    }

    public Player getPlayer() {
        return p;
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
                    try {
                        validCommand.execute(input, this);
                    } catch (GameExitException ex) {
                        loop = false;
                    }

                } else {
                    io.displayText("Huh? I don't understand.");
                }

        } while (loop);
        this.setEndTime(new Date());
    }

    private Command getValidCommand(String input) {
        return Stream.of(commands).filter(cmd -> cmd.isValid(input, this)).findFirst().orElse(null);
    }

    public Location getLocationOf(String intendedLocationName) {
        for (Location location : locationList) {
            if (intendedLocationName.equalsIgnoreCase(location.getName())) {
                return location;
            }
        }

        return null;
    }
}
