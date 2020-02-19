package zi2019.zad2;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class Main {
    public static void printStudents(Iterable<Student> students, Predicate<Student> predicate) {
        for (Student s: students) {
            if (predicate.test(s)) {
                System.out.println(s.toString());
            }
        }
    }

    public static void printPair(Student first, Student last) {
        System.out.format("First and last student: %n\t%s%n\t%s%n", first, last);
    }

    public static void firstAndLastStudent(Iterable<Student> students, Comparator<Student>
            comparator, BiConsumer<Student, Student> action) {
        SortedSet<Student> sortedStudents = new TreeSet<>(comparator);
        students.forEach(s -> sortedStudents.add(s));
        action.accept(sortedStudents.first(), sortedStudents.last());
    }

    public static void main(String ... args) {
        List<Student> dataset = DbLoader.loadStudents();
        printStudents(dataset, new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getAvgGrade() > 3.5;
            }
        });
        firstAndLastStudent(dataset, Student.BY_AVGRADE, Main::printPair);
        BiConsumer<Student, Student> printGradeDifference = (Student s1, Student s2) ->
                System.out.format("Diff= \t%.2f%n", Math.abs(s1.getAvgGrade() - s2.getAvgGrade()));

        firstAndLastStudent(dataset, Student.BY_AVGRADE.reversed(), printGradeDifference);
    }






}
