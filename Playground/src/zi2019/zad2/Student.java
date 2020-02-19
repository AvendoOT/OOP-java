package zi2019.zad2;

import java.nio.file.SimpleFileVisitor;
import java.util.Comparator;

public class Student implements Comparable<Student> {
    private String jmbag;
    private String firstname;
    private String surname;
    private Double avgGrade;

    public Student(String jmbag, String firstname, String surname, Double avgGrade) {
        this.jmbag = jmbag;
        this.firstname = firstname;
        this.surname = surname;
        this.avgGrade = avgGrade;
    }

    public String getJmbag() {
        return jmbag;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public Double getAvgGrade() {
        return avgGrade;
    }

    @Override
    public String toString() {
        return "Student: " + jmbag + ", " + firstname + " " + surname + ", " + avgGrade;
    }

    @Override
    public int hashCode() {
        return (this.getJmbag() == null) ? 0 : getJmbag().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Student) {
            Student st = (Student)o;
            return this.getJmbag().equals(st.getJmbag());
        }
        return false;
    }

    @Override
    public int compareTo(Student student) {
        return this.getJmbag().compareTo(student.getJmbag());
    }

    public static final Comparator<Student> BY_SURNAME = (s1, s2) -> s1.compareTo(s2);
    public static final Comparator<Student> BY_AVGRADE = (g1, g2) -> g1.compareTo(g2);
}
