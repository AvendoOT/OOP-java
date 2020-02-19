package hr.fer.oop.zad1;

public class DoubleTuple extends Tuple<Double> {

    public DoubleTuple(Double ... args) {
        super(args);
    }
    public DoubleTuple(int size) { super(size);}

    public DoubleTuple multiplyWith(double multiplier) {
        for (int i = 0; i < this.len(); i++) {
            this.set(i, multiplier * this.get(i));
        }
        return this;
    }

    public static Tuple<Double> avg(Tuple<? extends Number> tuple, Tuple<? extends Number> tuple2) {
        Tuple<Double> newList = new Tuple<>(tuple.len());
        for (int i = 0; i < newList.len(); i++) {
            newList.set(i, (tuple.get(i).doubleValue() + tuple2.get(i).doubleValue())/2);
        }
        return newList;
        }
}
