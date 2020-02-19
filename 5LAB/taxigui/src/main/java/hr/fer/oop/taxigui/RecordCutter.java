package hr.fer.oop.taxigui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 *
 * @author Krešimir Pripužić <kresimir.pripuzic@fer.hr>
 */
public class RecordCutter {

    public static void main(String[] args) throws IOException {
        Stream<String> lines = Files.lines(Paths.get("/home/kpripuzic/Downloads/sorted_data.csv/data"));
        Stream<String> stream = lines.
                map(line -> new TaxiRideRecord(line)).limit(100000).map(record -> record.toString());
        
        Files.write(Paths.get("/home/kpripuzic/Downloads/sorted_data.csv/data_small.csv"), (Iterable<String>)stream::iterator);
    }
}
