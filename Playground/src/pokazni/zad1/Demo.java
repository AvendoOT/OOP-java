package pokazni.zad1;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String ... args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter path");
        String path = sc.nextLine().trim();
        sc.close();
        DbLoader loader = new DbLoader(path);
        Set<Driver> drivers = loader.loadDrivers();
        drivers.stream().filter(driver -> driver.getAddress().endsWith("Zagreb"))
                .sorted((d1, d2) -> Integer.compare((int)d2.getPid(), (int)d1.getPid()))
                .forEach(d -> System.out.println(d));

        Set<Long> l = drivers.stream().filter(driver -> driver.getSurname().startsWith("M")).map(d -> d.getPid()).collect(Collectors.toSet());

        System.out.println(l);
        System.out.println(drivers.stream().mapToLong(d -> d.getFirstname().length()).average().getAsDouble());
    }
}
