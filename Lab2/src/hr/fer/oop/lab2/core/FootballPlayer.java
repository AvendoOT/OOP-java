package hr.fer.oop.lab2.core;

import hr.fer.oop.lab2.welcomepack.Constants;
import hr.fer.oop.lab2.welcomepack.PlayingPosition;

public class FootballPlayer extends Person {
    private int playingSkill = Constants.DEFAULT_PLAYING_SKILL;
    private PlayingPosition playingPosition = Constants.DEFAULT_PLAYING_POSITION;

    public FootballPlayer() {
        super();
    }

    public FootballPlayer(String name, String country, int emotion,
                          int playingSkill, PlayingPosition playingPosition) {
        super(name, country, emotion);
        if (playingSkill>= Constants.MIN_PLAYING_SKILL && playingSkill <= Constants.MAX_PLAYING_SKILL)
            this.playingSkill = playingSkill;
        else System.err.println("Playing skill out of range");
        if (playingPosition != null) this.playingPosition = playingPosition;
        else System.err.println("Playing position cannot be null");
    }

    public int getPlayingSkill() {
        return playingSkill;
    }

    public PlayingPosition getPlayingPosition() {
        return playingPosition;
    }

}
