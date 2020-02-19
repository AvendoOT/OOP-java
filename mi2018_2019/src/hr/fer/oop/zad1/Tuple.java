package hr.fer.oop.zad1;

import java.util.ArrayList;
import java.util.List;

public class Tuple<T> {

    private List<T> list;

    public Tuple (T ... args) {
        list = new ArrayList<>(args.length);
        for (T arg : args) {
            list.add(arg);
        }
    }

    public Tuple(int size) {
        list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(null);
        }
    }

    public T get(int index) {
        return list.get(index);
    }
    public void set(int index, T value) {
        list.set(index, value);
    }

    public int len() {
        return list.size();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        int i = 0;
        for (T arg : list) {
            builder.append(arg);
            if (i < list.size() - 1) {
                builder.append(",");
            }
            i++;
        }
        builder.append(")");
        return builder.toString();
    }

}
