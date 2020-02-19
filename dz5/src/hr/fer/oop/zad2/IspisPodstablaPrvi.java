package hr.fer.oop.zad2;

import java.io.File;

public class IspisPodstablaPrvi implements Obrada {

    public boolean nastaviObradu = true;
    public boolean preskociDirektorij = false;
    private int dubina = 0;

    @Override
    public boolean ulazimUDirektorij(File dir) {
        print(dir, dubina);
        if(dir.getName().equals("src")) {
            preskociDirektorij = true;
        }
        dubina++;
        return true;
    }

    @Override
    public boolean izlazimIzDirektorija(File dir) {
        if(dir.getName().equals("src")) {
            preskociDirektorij = false;
        }
        dubina--;
        return true;
    }

    @Override
    public boolean naletioSamNaDatoteku(File file) {
        print(file, dubina);
        return true;
    }

    private static void print(File dir, int dubina) {
        if(dubina>0) {
            System.out.print(" ".repeat(2*dubina));
        }
        System.out.println(dubina == 0 ? dir: dir.getName());


    }
}
