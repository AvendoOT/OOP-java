package hr.fer.oop.zad2;

public class Fridge extends RemoteAbs {
    private double temperature;

    public Fridge(String id, boolean isPoweredOn, double temperature, boolean remote) {
        super(id, isPoweredOn, remote);
        this.temperature = temperature;
    }
}
