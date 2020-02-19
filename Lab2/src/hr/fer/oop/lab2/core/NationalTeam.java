package hr.fer.oop.lab2.core;

import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab2.welcomepack.Formation;
import hr.fer.oop.lab2.welcomepack.IMatchInspectableTeam;

public class NationalTeam extends Team {

    private String country = Constants.DEFAULT_COUNTRY;

    public NationalTeam() {
        super(Constants.MAX_NO_PLAYERS_NATIONAL);
    }

    public NationalTeam(String name, Formation formation, String country) {
        super(name, formation, Constants.MAX_NO_PLAYERS_NATIONAL);
        if (country != null) this.country = country;
        else System.err.println("Country cannot be null");
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean registerPlayer(FootballPlayer player) {
        if (player == null) return false;
        if (!player.getCountry().equals(country) ||
            getRegisteredPlayers().size() >= getRegisteredPlayers().getMaxSize())
            return false;
        getRegisteredPlayers().add(player);
        return true;
    }

    @Override
    public double calculateRating() {
        return Constants.THIRTY_PERCENT * getRegisteredPlayers().calculateSkillSum()
                + Constants.SEVENTY_PERCENT * getRegisteredPlayers().calculateEmotionSum();
    }

}
