package hr.fer.oop.collections;

public interface IList {
    public int size();
    public void insertAt(int index, String value);
    public void replace(int index, String value);
    public String get(int index);
    public void clear();
    public String Remove(int index);

    public default boolean isEmpty() {
        if (this.isEmpty()) return true;
        return false;
    }

    public default void add(String value) {
        this.insertAt(this.size() +1 , value);
    }
}
