package hr.fer.oop.lab2.core;

import hr.fer.oop.lab2.welcomepack.Constants;

/**
 * Abstract class which models a person. Has properties with default values.
 * ie. name, country, emotion
 * Emotion has a setter and a getter while name and country only have the latter
 */
public abstract class Person {

    private String name = Constants.DEFAULT_PLAYER_NAME;
    private String country = Constants.DEFAULT_COUNTRY;
    private int emotion = Constants.DEFAULT_EMOTION;

    public Person() {}

    /**
     * Second constructor that takes two strings and an int
     * @param name
     * @param country
     * @param emotion
     */
    public Person(String name, String country, int emotion) {
        if (name != null) this.name = name;
        else System.err.println("Name cannot be null");
        if (country != null) this.country = country;
        else System.err.println("Country cannot be null");
        setEmotion(emotion);
    }

    /**
     * getter for name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * getter for country
     * @return
     */
    public String getCountry() {
        return country;
    }

    /**
     * getter for emotion
     * @return
     */
    public int getEmotion() {
        return emotion;
    }

    /**
     * setter for emotion where the new value (integer) can only be greater
     * than minimal emotion and lesser than maximal emotion
     * @param emotion
     */
    public void setEmotion(int emotion) {
        if (emotion >= Constants.MIN_EMOTION && emotion <= Constants.MAX_EMOTION)
            this.emotion = emotion;
        else System.err.println("Emotion out of range");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass() ) return false;
        Person person = (Person) o;
        if (name == null || country == null) return false;
        if (this.name == person.name && this.country == person.country) return true;
        else return false;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

}
