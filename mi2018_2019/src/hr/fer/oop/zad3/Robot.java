package hr.fer.oop.zad3;

public class Robot implements Player {
    private String serialNumber;
    private String model;
    private Person contactPerson;

    public Robot(String serialNumber, String model) {
        this.serialNumber = serialNumber;
        this.model = model;
    }

    public String getSerialNumber() {return serialNumber;}
    public String getModel() {return model;}
    public Person getContactPerson(){return contactPerson;}
    public void setContactPerson(Person person) {if (person!=null) this.contactPerson = person;}

    @Override
    public String getNickname() {
        return serialNumber;
    }
}
