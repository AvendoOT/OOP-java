package hr.fer.oop.zad1;

import java.util.Collection;

public class ItemBox<T extends Item> extends Box<T> {
    public double boxValue() {
        double value = 0;
        Collection<Item> items = (Collection<Item>) getItems();
        // Collection<T> items = getItems();
        for (Item item : items) {
            value += item.getNetSalePrice();
        }
        return value;
    }
}
