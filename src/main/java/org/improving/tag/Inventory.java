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

    public Item getItem() {
        return items.get(0);
    }

    public String getInventoryDisplay() {
        // Sort items alphabetically
        var alex = items.stream().sorted(new ItemComparator()).map(i -> "\n  " + i)
                .reduce("You have these items: ", (answer, s) -> answer += s);

        var ethan = items.stream().map(i -> i.getName()).sorted()
                .reduce("You have these items: ", (str1, str2) -> str1 + "\n  " + str2);

        return alex;
    }
}
