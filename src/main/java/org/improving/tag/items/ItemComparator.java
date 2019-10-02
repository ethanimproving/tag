package org.improving.tag.items;

import java.util.Comparator;

public class ItemComparator implements Comparator<Item> {

    @Override
    public int compare(Item item1, Item item2) {
        var sort = 0;
        if (item1.getId() == item2.getId()) {
            sort = 0;
        } else if(item1.getId() > item2.getId()) {
            sort = 1;
        }
        return item1.getName().compareTo(item2.getName());
    }
}
