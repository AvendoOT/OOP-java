public enum Genre {
    COMEDY("Comedy", "Humor"),
    ACTION("Action", "Adrenaline"),
    SCIFI("Science Fiction", "Space battles"),
    DRAMA("Drama", "Dramatic");

    private String name;
    private String description;

    private Genre(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
}
