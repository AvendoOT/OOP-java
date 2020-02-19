package hr.fer.oop.zad1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Box<T> {

    private List<T> items = new ArrayList<>();

    public void add (T ... items) {
        for (T item : items) {
            this.items.add(item);
        }
    }
    public Collection<T> getItems() {
        return items;
    }

}
