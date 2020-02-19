import java.util.*;

public class MySet extends LinkedList<Person> implements Iterable<Person> {

    private List<Person> list;

    public MySet() {
        list = new LinkedList<>();
    }

    @Override
    public boolean add(Person person) {
        if (!contains(person)) {
            list.add(person);
            return super.add(person);
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Person> c) {
        for (Person p : c) {
            add(p);
        }
        return true;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) return true;
        if (o.getClass() != Person.class) return true;

        Person person = (Person) o;
        for (Person p : list) {
            if (person == p) return true;
            if (p.getFirstName().equals(person.getFirstName()) && p.getLastName().equals(person.getLastName())) return true;
        }
        return false;
    }


    @Override
    public Iterator<Person> iterator() {
        Iterator<Person> it = new Iterator<Person>() {
            private int size = MySet.this.list.size();
            private int pos = 0;

            @Override
            public boolean hasNext() {
                return size > 0;
            }

            @Override
            public Person next() {
                Person p = list.get(pos);
                pos++;
                size--;
                return p;
            }
        };
        return it;
    }
}
