package hr.fer.oop.zad2;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;

public class PrizeGame {
    private String name;
    private LocalDate drawDate;
    private Collection<Prize> prizes;

    public PrizeGame(String name, LocalDate drawDate) {
        this.name = name;
        this.drawDate = drawDate;
        prizes = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public LocalDate getDrawDate() {
        return drawDate;
    }

    public Collection<Prize> getPrizes() {
        return prizes;
    }

    public Prize addPrize(String description, double value) {
        Prize newPrize = new Prize(description, value);
        prizes.add(newPrize);
        return newPrize;
    }

}
