
public class Movie {
    private Person actor;
    private Person actress;
    private int year;
    private String title;
    private MySet actors;
    private Genre genre;

    public Movie(Person actor, Person actress, int year, String title,
                 Genre genre) {
        this.actor = actor;
        this.actress = actress;
        this.year = year;
        this.title = title;
        this.genre = genre;
        actors = new MySet();
    }

    public MySet getActors() {
        return actors;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        return title + "  (" + year + ", " + genre.getName().toUpperCase() + ")";
    }
}
