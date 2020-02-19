import java.util.Collection;
import java.util.Set;

public class Demo {
    public static void main(String ... args) {
//        Person p1 = new Person("Michael", "Fassbender");
//        Person p2 = new Person("Charlize", "Theron");
//        Person p3 = new Person("Robert", "DeNiro");
//
//        Movie movie = new Movie(p1, p2, 2013, "The Counselor", Genre.DRAMA);
//        System.out.println(movie.getActors().add(p3));
//        System.out.println(movie.getActors().add(p1));
//        System.out.println(movie.getActors().add(p2));
//        System.out.println(movie.getActors().add(new Person("Robert", "DeNiro")));
//        System.out.println(movie.getActors().add(null));
//        Collection<Person> actors = movie.getActors();
//        System.out.println(actors.size());
//        for (Person p : actors) System.out.println(p);

//        MovieLibrary library = new MovieLibrary(Helper.movies());
//        Set<Movie> all = library.getAll();
//        Helper.print("All movies - ", all);
//        System.out.println("Number of movies in library -  " + library.numberOfMovies());
//        all.clear();
//        System.out.println("Number of movies in library -  " + library.numberOfMovies());
//        System.out.println();
//
//        System.out.println("The first way");
//        for (int i = 0; i < library.numberOfMovies(); i++) {
//            Movie m = library.getMovie(i);
//            System.out.println(m);
//        }
//
//        System.out.println();
//        System.out.println("The second way");
//        for (Movie m : library) System.out.println(m);

//        MovieLibrary library = new MovieLibrary(Helper.movies());
//        Set<Movie> set = library.getByGenre(Genre.SCIFI);
//        Helper.print("SCIFI movies -  ", set);
//        System.out.println();
//        set = library.getByYear(2011);
//        Helper.print("Movies from 2011", set);

//        MovieLibrary filmoteka = new MovieLibrary(Helper.movies());
//        Set<Movie> set1 = filmoteka.getByActors();
//        Helper.print("Filmovi bez obzira na glumca:", set1);
//        Set<Movie> set2 = filmoteka.getByActors(new Person("Pero", "Perić"));
//        Helper.print("Filmovi od Pere:", set2);
//        Set<Movie> set3 = filmoteka.getByActors(
//                new Person("Jasna", "Jasnić"), new Person("Pero", "Perić")
//        );
//        Helper.print("Filmovi od Jasne i Pere:", set3);

        MovieLibrary filmoteka = new MovieLibrary(Helper.movies());
        Set<Movie> set2 = filmoteka.getByActors();
        set2.removeAll(filmoteka.getByActors(new Person("Jasna", "Jasnić"), new Person("Pero", "Perić")));
        Helper.print("Filmovi bez Jane i Pere:", set2);






    }
}
