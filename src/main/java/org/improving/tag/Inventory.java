package org.improving.tag;

import org.improving.tag.items.Item;
import org.improving.tag.items.ItemComparator;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public String getInventoryDisplay() {
        String displayString = "You have these items: ";
        // Sort items alphabetically
        items.sort(new ItemComparator());
        for (Item item : items) {
            displayString += "\n  " + item;
        }
        return displayString;
    }

    public Item getItem() {
        return items.get(0);
    }
}
