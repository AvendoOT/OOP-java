package hr.fer.oop.zad3;


import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class JavaNIO {
    public static void main(String...args) throws IOException{

        Path path = Paths.get(args[0]).toAbsolutePath();

        if(!Files.exists(path)) {
            System.out.println("Zadali ste putanju koja ne postoji.");
            return;
        }

        if(Files.isRegularFile(path)) {
            System.out.println("Zadali ste putanju do datoteke.");
            return;
        }

        IzracunNajvece izr = new IzracunNajvece();
        Files.walkFileTree(path, izr);
        Map<Path, Long> mapa = izr.getMapa();
        if(mapa.size() == 0) {
            System.out.println("U mapi nema datoteka s ekstenzijom java.");
            return;
        }
        //System.out.print(mapa);
        Path najveca = null;
        long najvecaVelicina = 0;
        for(Map.Entry<Path, Long> par : mapa.entrySet()) {
            if(najveca == null) {
                najveca = par.getKey();
                najvecaVelicina = Files.size(najveca);
            }
            if(par.getValue() > najvecaVelicina) {
                najveca = par.getKey();
                najvecaVelicina = Files.size(najveca);
            }
        }

        System.out.printf("Najveca datoteka je %s a velicina joj je %d.%n", najveca, Files.size(najveca));

    }

    private static class IzracunNajvece extends SimpleFileVisitor<Path> {
        Map<Path, Long> mapa = new HashMap<>();

        public Map<Path, Long> getMapa() {
            return mapa;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (izvadiEkstenziju(file.getFileName().toString()).equals("java")) {
                Path path = file.toAbsolutePath();
                mapa.put(path, Files.size(file));
            }
            return FileVisitResult.CONTINUE;
        }

        private static String izvadiEkstenziju(String name) {
            int pozicija = name.lastIndexOf(".");
            if (pozicija < 1) return "";
            return name.substring(pozicija + 1).toLowerCase();
        }
    }
}
