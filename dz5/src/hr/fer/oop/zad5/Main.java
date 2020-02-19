package hr.fer.oop.zad5;

import java.io.IOException;
import java.nio.file.*;

public class Main {
    private static Path path;

    public static void main (String...args) throws IOException {

        if(args.length == 0) {
            path = Paths.get(".").normalize().toAbsolutePath();
        }
        if(args.length == 1) {
            path = Paths.get(args[0]).normalize().toAbsolutePath();
        }
        else {
            throw new IllegalArgumentException("Unesite najvise jednu stazu!");
        }

        System.out.println("Zadan je direktorij: " + path.getFileName());

        try(DirectoryStream<Path> str = Files.newDirectoryStream(path)) {
            for(Path p : str) {
                if(Files.isDirectory(p.toAbsolutePath())) {
                    System.out.println("[DIR] " + p.getFileName());
                }
                else {
                    System.out.println("[FIL] " + p.getFileName() + Files.size(p.toAbsolutePath()));
                }
            }
        }
        catch(DirectoryIteratorException ex) {
            throw ex.getCause();
        }
    }

}
