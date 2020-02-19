package hr.fer.oop.zad2;

import java.io.File;

public class IspisPodstablaDrugi implements Obrada {

    public boolean nastaviObradu = true;
    public boolean preskociDirektorij = false;
    private int dubina = 0;

    @Override
    public boolean ulazimUDirektorij(File dir) {
        print(dir, dubina);
        dubina++;
        return true;
    }

    @Override
    public boolean izlazimIzDirektorija(File dir) {
        dubina--;
        return true;
    }

    @Override
    public boolean naletioSamNaDatoteku(File file) {
        print(file, dubina);
        if(file.getName().endsWith("java")) {
            nastaviObradu = false;
        }
        return true;
    }

    private static void print(File dir, int dubina) {
        if(dubina>0) {
            System.out.print(" ".repeat(2*dubina));
        }
        System.out.println(dubina == 0 ? dir: dir.getName());


    }
}
