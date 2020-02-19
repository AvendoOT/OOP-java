package hr.fer.oop.zad2;

public class Television extends Device {
    
    private final double screenSize;

    public Television(String id, boolean isPoweredOn, double screenSize) {
        super(id, isPoweredOn);
        this.screenSize = screenSize;
    }
}
