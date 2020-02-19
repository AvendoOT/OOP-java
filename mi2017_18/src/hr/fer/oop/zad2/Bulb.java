package hr.fer.oop.zad2;

public class Bulb extends RemoteAbs{

    private Color color;

    public Bulb(String id, boolean isPoweredOn, Color color, boolean remote) {
        super(id, isPoweredOn, remote);
        this.color = color;
    }
}
