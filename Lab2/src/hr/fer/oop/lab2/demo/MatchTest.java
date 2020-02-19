package hr.fer.oop.lab2.demo;

import hr.fer.oop.lab2.core.ClubTeam;
import hr.fer.oop.lab2.core.Match;
import hr.fer.oop.lab2.core.NationalTeam;
import hr.fer.oop.lab2.welcomepack.Formation;
import hr.fer.oop.lab2.welcomepack.MatchType;

public class MatchTest {
    public static void main(String ... args) {
        ClubTeam bayern = new ClubTeam("Bayern Munchen", Formation.F352, 50);
        ClubTeam liverpool = new ClubTeam("FC Liverpool", Formation.F442, 70);
        NationalTeam croatia = new NationalTeam("CRO", Formation.F442, "Croatia");
        NationalTeam france = new NationalTeam("FRA", Formation.F541, "France");
        Match match = new Match(bayern, liverpool, MatchType.COMPETITIVE);
        if (match.isPlayable()) System.out.println("Match is playable");
        else System.out.println("Match is not playable");
        match.play();
        System.out.println(match.getOutcome());
    }
}
