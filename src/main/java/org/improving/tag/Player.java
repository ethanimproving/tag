package org.improving.tag;

import org.improving.tag.items.UniqueItems;

public class Player {
    private String name = "The Player";
    private int hitPoints = 100;
    private Location location;
    private Inventory inventory = new Inventory();

    public Player(Location location) {
        this.location = location;
        this.getInventory().addItem(UniqueItems.EGGO_WAFFLE);
        this.getInventory().addItem(UniqueItems.EVERLASTING_GOBSTOPPER);
        this.getInventory().addItem(UniqueItems .UNFORGETTABLE_MUSHROOM);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getHitPoints() {
        return hitPoints;
    }
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
}