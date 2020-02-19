package zi2019.zad1;

import java.io.*;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class MainLogic {
    public static void main(String ... args) {
        List<Car> listOfCars = new LinkedList<>();
        String path = "data/Archive.zip";
        try (ZipFile zipFile = new ZipFile(path)) {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                if (entry.getName().toLowerCase().endsWith(".txt")) {
                    try(InputStream is = zipFile.getInputStream(entry)){
                        BufferedReader br = new BufferedReader(
                                new InputStreamReader(new BufferedInputStream(is), "UTF-8"));
                        String line = br.readLine();
                        while (line != null) {
                            String[] parts = line.split(";");
                            listOfCars.add(new Car(parts[0], parts[1], Integer.parseInt(parts[2]),
                                    Integer.parseInt(parts[3]), parts[4], Integer.parseInt(parts[5]), Double.parseDouble(parts[6])));
                            line = br.readLine();

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Writer bw = new BufferedWriter(new OutputStreamWriter(
                    new BufferedOutputStream(new FileOutputStream("/izvjestaj.txt")), "UTF-8"));
            List<String> manufacturers = new LinkedList<>();
            listOfCars.stream()
                    .map(car -> car.getManufacturer()).distinct().forEach(c -> manufacturers.add(c));
            for (String s : manufacturers) {
                long count = listOfCars.stream().filter(car -> car.getManufacturer().equals(s)).count();
                bw.write(s + " " + Long.toString(count) + "\n");
            }

            double d = listOfCars.stream().filter(car -> car.getYearOfManufacture() < 2015)
                    .mapToDouble(c -> c.getYearOfManufacture()).average().getAsDouble();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
