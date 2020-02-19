package hr.fer.oop.lab2.core;
import hr.fer.oop.lab2.welcomepack.IMatchInspectableTeam;
import hr.fer.oop.lab2.welcomepack.IPlayableMatch;
import hr.fer.oop.lab2.welcomepack.MatchOutcome;
import hr.fer.oop.lab2.welcomepack.MatchType;

import java.util.Random;

public class Match implements IPlayableMatch {
    private static final int MIN_RANDOM = 0;
    private static final int MAX_RANDOM = 1;
    private IMatchInspectableTeam home;
    private Team away;
    private MatchType type;
    private MatchOutcome outcome = MatchOutcome.NOT_AVAILABLE;

    public Match(Team home, Team away,
                 MatchType type) {
        boolean flag = true;
        if (home == null) {
            this.home = home;
            flag = false;
        }
        if (away == null) {
            this.away = away;
            flag = false;
        }
        if (type == null) {
            this.type = type;
            flag = false;
        }
        if (flag) {
            if (home.getClass() == NationalTeam.class) this.home = (NationalTeam) home;
            else this.home = (ClubTeam) home;
            if (away.getClass() == NationalTeam.class) this.away = (NationalTeam) away;
            else this.away = (ClubTeam) away;
            this.type = type;
        }

    }

    public Team getHome() {
        return home;
    }

    public Team getAway() {
        return away;
    }

    public MatchType getType() {
        return type;
    }

    public MatchOutcome getOutcome() {
        return outcome;
    }

    @Override
    public boolean isPlayable() {
        if (home == null || away == null || type == null) return false;
        if (type == MatchType.COMPETITIVE) {
            if (home.getClass() == NationalTeam.class && away.getClass() == NationalTeam.class) return true;
            if (home.getClass() == ClubTeam.class && away.getClass() == ClubTeam.class) return true;
            else return false;
        }
        return true;
    }

    @Override
    public void play() {
        double h = home.calculateRating();
        double a = away.calculateRating();
        double suma = h+a;
        h = h/suma;
        a = a/suma;
        double min;
        if (h < a) min = h;
        else min = a;
        Random random = new Random();
        double randomValue = MIN_RANDOM + (MAX_RANDOM - MIN_RANDOM)*random.nextDouble();
        if (randomValue < h - min/2) outcome = MatchOutcome.HOME_WIN;
        else if (randomValue > h + min/2) outcome = MatchOutcome.AWAY_WIN;
        else outcome = MatchOutcome.DRAW;
    }


}
