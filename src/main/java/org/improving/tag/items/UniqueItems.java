package org.improving.tag.items;

public enum UniqueItems implements Item {
    THE_ONE_RING("The One Ring", "A golden ring"),
    BLUE_SHELL("Blue Shell", "A blue shell with wings"),
    GOLDEN_HAMMER("Golden Hammer", "A golden hammer that fixes everything"),
    EGGO_WAFFLE("Eggo Waffle", "Part of a balanced breakfast"),
    UNFORGETTABLE_MUSHROOM("Unforgettable Mushroom", "An edible toad"),
    EVERLASTING_GOBSTOPPER("Everlasting Gobstopper","A gobstopper that never loses its flavor"),
    NOTHING("","");

    private final String description;
    private String name;

    UniqueItems(String name, String description) {
        this.description = description;
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }


}
