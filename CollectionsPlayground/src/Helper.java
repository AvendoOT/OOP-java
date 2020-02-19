import java.util.Arrays;
import java.util.Collection;
import java.util.Arrays;
import java.util.Collection;

public class Helper {
    public static Collection<Movie> movies() {
        Person o1 = new Person("Jasna", "Jasnić");
        Person o2 = new Person("Ivo", "Ivić");
        Person o3 = new Person("Pero", "Perić");
        Person o4 = new Person("Kristina", "Karlić");
        Person o5 = new Person("Marta", "Martić");
        Person o6 = new Person("Jakov", "Jakić");
        Movie f1 = new Movie(o2, o1, 2010, "Pogled iz Miramarske", Genre.COMEDY);
//        f1.getActors().add(o1);
//        f1.getActors().add(o2);
//        f1.getActors().add(o3);
        f1.getActors().addAll(Arrays.asList(o1, o2, o3));
        Movie f2 = new Movie(o3, o4, 2011, "Sjećanja s Marsa", Genre.SCIFI);
        f2.getActors().addAll(Arrays.asList(o3, o4, o1, o2));
        Movie f3 = new Movie(o6, o5, 2011, "Vode Save", Genre.ACTION);
        f3.getActors().addAll(Arrays.asList(o6, o5, o3, o4));
        Movie f4 = new Movie(o2, o5, 2011, "Bespućima Mliječne staze", Genre.SCIFI);
        f4.getActors().addAll(Arrays.asList(o2, o5, o1, o3));
        return Arrays.asList(f1, f2, f3, f4, f2, f4);
    }
        // Pitanje - razmislite: što znamo da su elementi od opredanog iterable???
        public static void print(String naslov, Iterable <?> col){
            System.out.println(naslov);
            System.out.println("-----------------------");
            for (Object o : col) {
                System.out.println(o);
            }
            System.out.println();
        }
    }
