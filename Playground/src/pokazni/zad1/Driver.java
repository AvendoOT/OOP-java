package pokazni.zad1;

public class Driver {
    public String firstname;
    public String surname;
    public String address;
    public long pid;

    public Driver(String firstname, String surname, String address, long pid) {
        this.firstname = firstname;
        this.surname = surname;
        this.address = address;
        this.pid = pid;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public long getPid() {
        return pid;
    }

    @Override
    public String toString() {
        return firstname + " " + surname + ": " + address + " " + pid;
    }
}
