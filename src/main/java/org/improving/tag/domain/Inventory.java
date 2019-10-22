package org.improving.tag.domain;

import org.improving.tag.items.Item;
import org.improving.tag.items.ItemComparator;
import org.improving.tag.items.UniqueItems;

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

    public Item getItem() {
        if (items.size() > 0) return items.get(0);
        else return UniqueItems.NOTHING;
    }

    public String getInventoryDisplay() {
        // Sort items alphabetically
        return items.stream().sorted(new ItemComparator()).map(i -> "\n  " + i)
                .reduce("You have these items: ", (answer, s) -> answer += s);
    }
}
