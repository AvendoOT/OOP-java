package pokazni.zad1;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Set;

public class DbLoader extends SimpleFileVisitor<Path>  {

    private Set<Driver> drivers = new HashSet<>();
    private File file;

    public DbLoader(String path) {
        if (!Files.exists(Paths.get(path))) {
            System.err.println("Path doesn't exist");
        }
        else {
            file = new File(path);
        }
    }

    public Set<Driver> loadDrivers() throws IOException {
        FileVisitor<Path> visitor = this;
        Files.walkFileTree(file.toPath(), visitor);
        return drivers;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toString().endsWith(".txt")) {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new BufferedInputStream(new FileInputStream(file.toString()))
                            , "UTF-8"));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                drivers.add(new Driver(parts[0].trim(), parts[1].trim(), parts[2].trim(), Long.parseLong(parts[3].trim())));
                line = reader.readLine();
            }
            reader.close();
        }
        return FileVisitResult.CONTINUE;
    }





}
