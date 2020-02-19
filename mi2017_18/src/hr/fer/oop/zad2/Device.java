package hr.fer.oop.zad2;

import org.w3c.dom.ls.LSOutput;

public abstract class Device {
    private final String ID;
    private boolean isPoweredOn;
    public Device(String id, boolean isPoweredOn) {
        ID = id;
        this.isPoweredOn = isPoweredOn;
    }

    public String getID() {
        return ID;
    }

    public boolean isPoweredOn() {
        return isPoweredOn;
    }

    public void setPoweredOn(boolean isPoweredOn) {
        this.isPoweredOn = isPoweredOn;
    }

    public void switchPower() {
        isPoweredOn = !isPoweredOn;
    }
    }
