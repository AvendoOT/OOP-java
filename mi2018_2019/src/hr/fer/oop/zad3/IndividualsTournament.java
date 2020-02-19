package hr.fer.oop.zad3;

public class IndividualsTournament extends Tournament {

    public IndividualsTournament(String name, String when) {
        super(name, when);
    }

    @Override
    public boolean addCompetitor(Competitor competitor) {
        if (competitor == null) return false;
        if (competitor instanceof Player) {
            return super.addCompetitor(competitor);
        }
        else return false;
    }
}
