package hr.fer.oop.lab4.zadLab;

public class Artikl implements Comparable<Artikl>{

    private String naziv;
    private String cijena;
    private String pdv;

    public Artikl(String naziv, String cijena, String pdv){
        this.naziv = naziv;
        this.cijena = cijena;
        this.pdv = pdv;
    }

    public String getCijena () {
        return cijena;
    }

    public String getNaziv () {
        return naziv;
    }

    public String getPdv() {return pdv;}

    @Override
    public boolean equals ( Object o ) {
       return this.naziv.equals(naziv);
    }

    @Override
    public int hashCode () {
        return this.naziv.hashCode();
    }

    @Override
    public int compareTo ( Artikl o ) {
        return this.naziv.compareTo(o.getNaziv());
    }
}
