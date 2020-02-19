package hr.fer.oop.zad2;

import java.io.File;

public interface Obrada {

    boolean ulazimUDirektorij(File dir);
    boolean izlazimIzDirektorija(File dir);
    boolean naletioSamNaDatoteku(File file);
}
