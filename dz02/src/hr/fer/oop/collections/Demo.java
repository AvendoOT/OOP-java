package hr.fer.oop.collections;

import java.util.ArrayList;
import java.util.Collection;

public class Demo {
    public static void main(String ... args) {
        String[] strings = new String[] {"Leon", "Kranjcevic",
            "fer"};
        ArrayBackedList list = new ArrayBackedList(strings);
        list.print();
        String[] strings1 = {"Leon", "Kranjcevic"};
        IList test = new ArrayBackedList(strings1);
        new ArrayBackedList(test);


    }
}
