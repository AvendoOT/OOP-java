package zi2018.zad2;

import java.util.Comparator;

public class Car implements Comparable<Car> {
    private String manufacturer;
    private String model;
    private String id;
    private float power;
    Politician owner;

    public Car(String manufacturer, String model, String id, float power, Politician owner) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.id = id;
        this.power = power;
        this.owner = owner;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }

    public Politician getOwner() {
        return owner;
    }

    public void setOwner(Politician owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Car{" + "manufacturer=" + manufacturer + ", model=" + model + ", id=" + id + ", power=" + power + ", owner=" + owner + '}';
    }

    @Override
    public int compareTo(Car car) {
        return this.id.compareTo(car.id);
    }

    public static final Comparator<Car> BY_MANUFACTURER = (m1, m2) -> m1.getManufacturer().compareTo(m2.getManufacturer());
    public static final Comparator<Car> BY_ID = (i1, i2) -> i1.getId().compareTo(i2.getId());
    public static final Comparator<Car> BY_OWNER = (o1, o2) -> o1.getOwner().compareTo(o2.getOwner());

}
