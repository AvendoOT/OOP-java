package zi2018.zad2;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Program {
    public static void main(String... args) {
        List<Politician> politicians = DbLoader.loadPoliticians();
        List<Car> cars = DbLoader.loadCars();
        Collections.sort(politicians);
        for (Politician politician : politicians) {
            System.out.println(politician.toString());
        }
        Collections.sort(cars);
        //for (Car car : cars) System.out.println(car.toString());
        cars.stream().forEach(c -> System.out.println(c.toString()));
        Set<Car> carSort = new TreeSet<>(Car.BY_MANUFACTURER.reversed().thenComparing(Car.BY_OWNER));
        //cars.stream().forEach(c ->  carSort.add(c));
        carSort.addAll(cars);
        carSort.stream().forEach(c -> c.toString());
    }
}
