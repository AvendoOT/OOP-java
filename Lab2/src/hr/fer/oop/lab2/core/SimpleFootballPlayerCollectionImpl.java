package hr.fer.oop.lab2.core;

import hr.fer.oop.lab2.welcomepack.SimpleFootballPlayerCollection;

public class SimpleFootballPlayerCollectionImpl implements SimpleFootballPlayerCollection {
    private FootballPlayer[] players;

    public SimpleFootballPlayerCollectionImpl(int size) {
        players = new FootballPlayer[size];
    }

    @Override
    public int size() {
        int size = 0;
        for (FootballPlayer player : players) {
            if (player != null) size++;
        }
        return size;
    }

    @Override
    public boolean contains(FootballPlayer player) {
        if (player == null) return false;
        for (FootballPlayer p : players) {
            if (p == null) continue;
            if (player.equals(p)) return true;
        }
        return false;
    }

    @Override
    public boolean add(FootballPlayer player) {
        if (!contains(player)) {
            for (int i = 0; i < players.length; i++) {
                if (players[i] == null) {
                    players[i] = player;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < players.length; i++) {
            players[i] = null;
        }
    }

    @Override
    public int getMaxSize() {
        return players.length;
    }

    @Override
    public int calculateEmotionSum() {
        int sum = 0;
        for (FootballPlayer player : players) {
            if (player != null)
            sum += player.getEmotion();
        }
        return sum;
    }

    @Override
    public int calculateSkillSum() {
        int sum = 0;
        for (FootballPlayer player : players) {
            if (player != null)
            sum += player.getPlayingSkill();
        }
        return sum;
    }

    @Override
    public FootballPlayer[] getPlayers() {
        return players;
    }
}
