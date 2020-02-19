package zi2018.zad2;

public class Politician implements Comparable<Politician>{

    private String oib;
    private String firstname;
    private String surname;
    private String party;

    public Politician(String oib, String firstname, String surname, String party) {
        this.oib = oib;
        this.firstname = firstname;
        this.surname = surname;
        this.party = party;
    }

    @Override
    public int hashCode() {
        return (this.oib == null) ? 0 : oib.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Politician) {
            Politician p = (Politician)o;
            return (this.oib != null) && this.oib.compareTo(p.oib) == 0;
        }
        return false;
    }

    @Override
    public int compareTo(Politician o) {
        int r = this.party.compareTo(o.party);
        if (r != 0) return r;
        return this.oib.compareTo(o.oib);
    }

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    @Override
    public String toString() {
        return "Politician{" + "oib=" + oib + ", firstname=" + firstname + ", surname=" + surname + ", party=" + party + '}';
    }

}
