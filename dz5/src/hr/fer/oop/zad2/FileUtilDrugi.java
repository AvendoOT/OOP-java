package hr.fer.oop.zad2;

import java.io.File;

public class FileUtilDrugi {
    public static void obidiPodstablo(File dir, IspisPodstablaDrugi obr){

        if(!obr.nastaviObradu) {
            return;
        }

        if(obr.preskociDirektorij) {
            obr.izlazimIzDirektorija(dir);
            return;
        }

        File[] djeca = dir.listFiles();
        if(djeca == null) {
            return;
        }

        obr.ulazimUDirektorij(dir);
        for(File dijete : djeca) {
            if(!obr.nastaviObradu) break;
            if(dijete.isDirectory()) {
                obidiPodstablo(dijete, obr);
            }
            else {
                obr.naletioSamNaDatoteku(dijete);
            }
        }

        obr.izlazimIzDirektorija(dir);
    }
}
