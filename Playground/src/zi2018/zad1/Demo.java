package zi2018.zad1;

import java.io.IOException;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class Demo {
    public static void main(String ... args) throws IOException {
        Path handball = Paths.get("Handball");
        HandballVisitor vis = new HandballVisitor();
        FileVisitor<Path> visitor = vis;
        Files.walkFileTree(handball, visitor);
        List<Player> players = vis.getListOfPlayers();
        players.stream().filter(player -> player.getGoals() > 5)
                .sorted((p1, p2) -> Integer.compare(p2.getGoals(), p1.getGoals()))
                .forEach(p->{
                 System.out.println(p.getName() + " " + p.getGoals());
                });
        List<String> teams = new LinkedList<>();
        players.stream().map(player -> player.getTeam()).distinct().forEach(p -> teams.add(p));
        for (String team : teams) {
            double d = players.stream().filter(player -> player.getTeam().equals(team)).mapToDouble(p -> p.getGoals()).average().getAsDouble();
            System.out.println(team + " " + d);
        }





    }
}
