package zi2018.zad1;

import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

public class HandballVisitor extends SimpleFileVisitor<Path> {
    private static List<Player> listOfPlayers = new LinkedList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toString().endsWith(".txt")) {
            BufferedReader bf = new BufferedReader(
                    new InputStreamReader(
                            new BufferedInputStream(new FileInputStream(file.toString())), "UTF-8"
                    )
            );
            String[] names = file.toString().split("/");
            String teamName = names[names.length-1].substring(0, names[names.length-1].indexOf("."));
            String line = bf.readLine();
            while (line != null) {
                String[] parts = line.split(";");
                listOfPlayers.add(new Player(parts[0], parts[1], teamName,
                        Integer.parseInt(parts[2]),  Integer.parseInt(parts[3]),  Integer.parseInt(parts[4])));
                line = bf.readLine();
            }
            bf.close();
        }
        return FileVisitResult.CONTINUE;
    }

    public List<Player> getListOfPlayers() {return listOfPlayers;}

}
