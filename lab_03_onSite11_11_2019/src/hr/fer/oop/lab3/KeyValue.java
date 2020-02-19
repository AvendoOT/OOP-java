package hr.fer.oop.lab3;

public class KeyValue<K, V> {
    private K key;
    private V value;
    public KeyValue(K k, V v) {
        key = k;
        value = v;
    }
    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }
    public void setKey(K newKey) {
        key = newKey;
    }
    public void setValue(V newValue) {
        value = newValue;
    }

    static <T extends Comparable> KeyValue<?,?> min(T[] args) {
        if (args == null) return null;
        if (args.length == 0) return new KeyValue<>(0,0);
        T min = args[0];
        int i = 0;
        for (T t : args) {
            if (t.compareTo(min) < 0) min = t;
        }
        for (T s : args) {
            if (s.equals(min)) i++;
        }
        return new KeyValue<>(min, i);
    }
}
