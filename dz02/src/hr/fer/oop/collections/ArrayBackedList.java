/**
 * ArrayBackedList is a class that has a private property of type String
 * that is an array. Starting size is 2 and it increments by private constant
 * INCREMENT by twice the value beforehand - exponential growth
 * @author Leon Kranjcevic
 * @version 1.0
 * @since 2019-1-11
 * @DZ-02
 */
package hr.fer.oop.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ArrayBackedList implements IList {
    private static final int INCREMENT = 2;
    private static String[] stringArray = new String[2];

    /**
     * Basic empty constructor
     */
    public ArrayBackedList() {}

    /**
     * Constructor that takes IList parameter and copies it's content into
     * stringArray property. It's checks if the length of array will be
     * insufficient to store new values with reallocArray()
     * @param list
     */
    public ArrayBackedList(IList list) {
        while (list.size() > stringArray.length) {
            reallocArray();
        }
        for (int i = 0; i < list.size(); i++) {
            stringArray[i] = list.get(i);
        }
    }

    /**
     * Method that takes an array of string of any given length
     * and copies it to starting array
     * @param strings
     */
    public ArrayBackedList(String ... strings) {
        insertArray(Arrays.asList(strings));
    }

    /**
     * Method that expands stringArray (present length * Increment) and
     * copies values that very stored before with Arrays.copyof(...)
     * @return Nothing
     */
    private void reallocArray() {
            this.stringArray = Arrays.copyOf
                    (stringArray, stringArray.length*INCREMENT);
    }

    /**
     * Expands and inserts a list of string to stringArray.
     * @param strings
     * @return Nothing
     */
    private void insertArray(List<String> strings) {
        while (strings.size() > stringArray.length) {
            reallocArray();
        }
        int i = 0;
        for(String string : strings) {
            if (string != null) stringArray[i++] = string;
        }
    }

    @Override
    public int size() {
        int i = 0;
        for (String string : stringArray) {
            if (string != null) i++;
        }
        return i;
    }

    @Override
    public void insertAt(int index, String value) {
        while (index > this.size()) reallocArray();
        this.stringArray[index] = value;
    }

    @Override
    public void replace(int index, String value) {
        if (index < this.size()) this.stringArray[index] = value;
        else insertAt(index, value);
    }

    @Override
    public String get(int index) {
        if (index > this.size()) return null;
        return this.stringArray[index];

    }

    @Override
    public void clear() {
        for(int i = 0; i < stringArray.length; i++) {
            stringArray[i] = null;
        }
    }

    @Override
    public String Remove(int index) {
        if (index > stringArray.length) return null;
        String proxy = stringArray[index];
        stringArray[index] = null;
        return proxy;
    }

    public static void print() {
        for (String string : stringArray) {
            if (string != null) System.out.println(string);
        }
    }
}
