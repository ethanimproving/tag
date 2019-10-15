package org.improving.tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Exit {
    private int id;
    private String name;
    private Location destination;
    private List<String> aliases = new ArrayList<>();

    public Exit() { }

    public Exit(String name, Location destination, String...aliases) {
        this.name = name;
        this.destination = destination;
        this.aliases.addAll(Arrays.asList(aliases));
    }

    public int getId() {
        return id;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public List<String> getAliases() {
        return aliases;
    }

    @Override
    public String toString() {
        return this.getName();
    }

//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = (31 * hash) + (this.getName() == null ? 0 : getName().hashCode());
//        hash = (31 * hash) + (this.getDestination() == null ? 0 : getDestination().hashCode());
//        return hash;
//    }


    @Override
    public int hashCode() {
        return Objects.hash(name, destination);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Exit) {
            Exit exit = (Exit)obj;
            return this.getName().equals(exit.getName()) &&
                    this.getDestination().equals(exit.getDestination());
        }
        return super.equals(obj);
    }

    public void setDestinationId(int destinationId) {
        this.id = destinationId;
    }

    public void addAlias(String alias) {
        this.aliases.add(alias);
    }
}
