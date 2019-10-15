package org.improving.tag;

import org.improving.tag.items.Item;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "location")
public class Location {
    @Id
    private int id;

    @Column(name="Name")
    private String name = "";

    @Column(name="Description")
    private String description = "";

    @Transient
    private List<String> tags = new ArrayList<>();

    @Transient
    private List<Exit> exits = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="AdversaryId")
    private Adversary adversary;

    @Transient
    private TreasureChest treasureChest = TreasureChest.NO_TREASURE;

    public Item openTreasureChest() {
        if (TreasureChest.NO_TREASURE.equals(treasureChest)) {
            throw new UnsupportedOperationException();
        }
        Item treasure = treasureChest.getItem();
        treasureChest = TreasureChest.NO_TREASURE;
        return treasure;
    }

    public void setTreasureChest(TreasureChest treasureChest) {
        this.treasureChest = treasureChest;
    }

    public int getId() {
        return id;
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

    public Adversary getAdversary() {
        return adversary;
    }

    public void setAdversary(Adversary adversary) {
        this.adversary = adversary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTags() {
        return tags;
    }

    public List<Exit> getExits() {
        return exits;
    }

    public String getTreasureDescription() {
//        if (TreasureChest.NO_TREASURE.equals(treasureChest)) {
//            throw new UnsupportedOperationException();
//        }
        return treasureChest.getDescription();
    }

    public TreasureChest getTreasureChest() {
        return treasureChest;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Location) {
            Location location = (Location)obj;
            return this.getName().equals(location.getName()) &&
                    this.getDescription().equals(location.getDescription());
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public void setExits(List<Exit> exits) {
        this.exits = exits;
    }

}



