package org.improving.tag.domain;

import org.improving.tag.items.UniqueItems;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name = "chest")
public class TreasureChest {

    @Transient
    public static final TreasureChest NO_TREASURE = new TreasureChest(UniqueItems.NOTHING, "");

    @Id
    private long id;

    @Column(name = "Item")
    private UniqueItems item = UniqueItems.NOTHING;

    @Column(name = "Description")
    private String description = "";

    public TreasureChest() {
    }

    public TreasureChest(UniqueItems item, String description) {
        this.item = item;
        this.description = description;
    }

    public UniqueItems getItem() {
        return item;
    }

    @Override
    public String toString() {
        return description;
    }

    public String getDescription() {
        return description;
    }
}
