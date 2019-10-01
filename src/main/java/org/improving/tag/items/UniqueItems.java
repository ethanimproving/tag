package org.improving.tag.items;

public enum UniqueItems implements Item {
    THE_ONE_RING("A golden ring"),
    BLUE_SHELL("A blue shell with wings"),
    GOLDEN_HAMMER("A golden hammer that fixes everything"),
    NOTHING("");

//    {
//        @Override
//        public String getDescription() {
//        throw new UnsupportedOperationException();
//    }
//    }

    private final String description;
    UniqueItems(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
