package zi2018.zad2;

import zi2018.zad2.Car;
import zi2018.zad2.Politician;

import java.util.Arrays;
import java.util.List;

public class DbLoader {
    public static List<Car> loadCars() {
        List<Politician> politicians = DbLoader.loadPoliticians();
        List<Car> cars = Arrays.asList(
                new Car("Audi", "A6", "123", 1, politicians.get(0)),
                new Car("BMW", "X5", "934", 3, politicians.get(1)),
                new Car("VW", "Passat", "345", 2, politicians.get(2)),
                new Car("Citroen", "C4", "278", 7, politicians.get(3))
        );
        return cars;
    }

    public static List<Politician> loadPoliticians() {
        List<Politician> politicians = Arrays.asList(
                new Politician("ZC132132", "Marko", "Markovic", "HDZ"),
                new Politician("AB963258", "Pero", "Peric", "HDZ"),
                new Politician("XY123547", "Josip", "Mikic", "Most"),
                new Politician("CD874561", "Ivan", "Ivic", "SDP")
        );
        return politicians;
    }
}
