import java.util.*;

public class MovieLibrary implements Iterable<Movie> {

    private Set<Movie> setter;

    public MovieLibrary(Collection<Movie> movies) {
        setter = new LinkedHashSet<>();
        setter.addAll(movies);
    }

    public  Set<Movie> getAll() {
        Set<Movie> proxySet = new LinkedHashSet<>();
        proxySet.addAll(setter);
        return proxySet;
    }

    public Set<Movie> getByGenre(Genre genre) {
        Set<Movie> proxySet = new LinkedHashSet<>();
        for (Movie m : setter) {
            if (m.getGenre().getName().equals(genre.getName())) {
                proxySet.add(m);
            }
        }
        return proxySet;
    }

    public Set<Movie> getByYear(int year) {
        Set<Movie> proxySet = new LinkedHashSet<>();
        for (Movie m : setter) {
            if (m.getYear() == year) {
                proxySet.add(m);
            }
        }
        return proxySet;
    }

    public int numberOfMovies() {
        return setter.size();
    }

    public Movie getMovie(int index) {
        ArrayList<Movie> array = new ArrayList<>(setter);
        return array.get(index);
    }

    public Set<Movie> getByActors (Person ... actors) {
        Set<Movie> proxySet = new LinkedHashSet<>();
        for (Movie movie : setter) {
            int count = 0;
            for (Person p : actors) {
                //Collection<Person> celebs = movie.getActors();
                for (Person person : movie.getActors()) {
                    if (p.getFirstName().equals(person.getFirstName()) && p.getLastName().equals(person.getLastName())) count++;
                }
            }
            if (count == actors.length && actors.length != 0) proxySet.add(movie);
            else if (actors.length == 0) proxySet.add(movie);
        }
        return proxySet;
    }

    @Override
    public Iterator<Movie> iterator() {
        Iterator<Movie> it = new Iterator<Movie>() {
            private int size = setter.size();
            private int pos = 0;
            ArrayList<Movie> array = new ArrayList<>(setter);

            @Override
            public boolean hasNext() {
                return size > 0;
            }

            @Override
            public Movie next() {
                Movie movie = array.get(pos);
                pos++;
                size--;
                return movie;
            }
        };
        return it;
    }
}
