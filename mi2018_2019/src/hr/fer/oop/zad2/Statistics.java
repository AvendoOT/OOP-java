package hr.fer.oop.zad2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Statistics {

    public static void printGamesByMonth(List<PrizeGame> prizeGames) {
        List<Set<String>> list = new ArrayList<>(12);
        for (int i = 0; i < 12; i++) {
            list.add(new TreeSet<>());
        }
        for (PrizeGame game : prizeGames) {
            int month = game.getDrawDate().getMonthValue();
            list.get(month-1).add(game.getName());
        }
        for (int i = 0; i < 12; i++) {
            if (list.get(i).size() > 0) {
                System.out.format("%d.%n", i+1);
                for (String string : list.get(i)) {
                    System.out.format("\t%s%n", string);
                }
            }
        }
    }

    public static Set<String> gameWinners(List<PrizeGame> prizeGames, String name) {
        Set<String> winners = new TreeSet<>();
        for (PrizeGame game : prizeGames) {
            if (game.getName().equals(name)) {
                for (Prize prize : game.getPrizes()) {
                    //winners.addAll(prize.getWinners());
                    for (String winner : prize.getWinners()) {
                        winners.add(winner);
                    }
                }
            }
        }
        return winners;


    }
}
