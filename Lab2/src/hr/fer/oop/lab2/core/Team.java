package hr.fer.oop.lab2.core;

import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab2.welcomepack.Formation;
import hr.fer.oop.lab2.welcomepack.IMatchInspectableTeam;
import hr.fer.oop.lab2.welcomepack.ManageableTeam;

public abstract class Team implements IMatchInspectableTeam {
    private String name = Constants.DEFAULT_TEAM_NAME;
    private Formation formation = Constants.DEFAULT_FORMATION;
    private SimpleFootballPlayerCollectionImpl registeredPlayers;
    private SimpleFootballPlayerCollectionImpl startingEleven = new SimpleFootballPlayerCollectionImpl(Constants.STARTING_ELEVEN_SIZE);

    public Team(int size) {
        registeredPlayers = new SimpleFootballPlayerCollectionImpl(size);
    }

    public Team(String name, Formation formation, int size) {
        if (name != null) this.name = name;
        else System.err.println("Name cannot be null");
        registeredPlayers = new SimpleFootballPlayerCollectionImpl(size);
        setFormation(formation);
    }

    public String getName() {
        return name;
    }

    @Override
    public Formation getFormation() {
        return formation;
    }

    @Override
    public SimpleFootballPlayerCollectionImpl getRegisteredPlayers() {
        return registeredPlayers;
    }

    @Override
    public SimpleFootballPlayerCollectionImpl getStartingEleven() {
        return startingEleven;
    }

    public void setFormation(Formation formation) {
        if (formation != null) this.formation = formation;
        else System.err.println("Formation cannot be null");
    }

    @Override
    public boolean addPlayerToStartingEleven(FootballPlayer player) {
        if (registeredPlayers.contains(player) && !startingEleven.contains(player)
        && startingEleven.size() < Constants.STARTING_ELEVEN_SIZE) {
            startingEleven.add(player);
            return true;
        }
        return false;
    }

    @Override
    public void clearStartingEleven() {
        startingEleven.clear();
    }

    @Override
    public boolean isPlayerRegistered(FootballPlayer player) {
        if (registeredPlayers.contains(player)) return true;
        return false;
    }







}
