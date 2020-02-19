package hr.fer.oop.zad4;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Prvi {

    private static class Visitor implements FileVisitor<Path> {
        private int dubina;

        public Visitor() {
            dubina = 0;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            System.out.println(" ".repeat(2*dubina) + dir.getFileName());
            if(dir.getFileName().toString().equals("src")) return FileVisitResult.SKIP_SUBTREE;
            dubina++;
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println(" ".repeat(2*dubina) + file.getFileName());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            dubina--;
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String... args) throws IOException {
        Path path = Paths.get(args[0]).toAbsolutePath();

        if(!Files.exists(path)) {
            System.out.println("Zadali ste putanju koja ne postoji.");
            return;
        }

        if(Files.isRegularFile(path)) {
            System.out.println("Zadali ste putanju do datoteke.");
            return;
        }

        Visitor visitor = new Visitor();
        Files.walkFileTree(path, visitor);


    }
}
