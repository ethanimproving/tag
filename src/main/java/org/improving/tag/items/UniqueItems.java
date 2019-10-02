package org.improving.tag.items;

public enum UniqueItems implements Item {
    THE_ONE_RING("The One Ring", "A golden ring", 1),
    BLUE_SHELL("Blue Shell", "A blue shell with wings", 2),
    GOLDEN_HAMMER("Golden Hammer", "A golden hammer that fixes everything", 3),
    EGGO_WAFFLE("Eggo Waffle", "Part of a balanced breakfast", 12),
    UNFORGETTABLE_MUSHROOM("Unforgettable Mushroom", "An edible toad", 777),
    EVERLASTING_GOBSTOPPER("Everlasting Gobstopper","A gobstopper that never loses its flavor", Integer.MAX_VALUE),
    NOTHING("","", 0);

//    {
//        @Override
//        public String getDescription() {
//        throw new UnsupportedOperationException();
//        }
//    }

    private final String description;
    private final int id;
    private String name;

    UniqueItems(String name, String description, int id) {
        this.description = description;
        this.name = name;
        this.id = id;
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

    @Override
    public int getId() {
        return this.id;
    }
}
