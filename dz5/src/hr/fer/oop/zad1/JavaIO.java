package hr.fer.oop.zad1;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;

public class JavaIO {

    public static void main(String... args) {

        File path = new File(args[0]);


        if(!path.isDirectory()) {
            System.out.println("Ovo nije direktorij!");
            return;
        }

        List<File> files = listaj(path, new Filter());
        if(files.size() < 1) {
            System.out.println("Nema nijedne java datoteke u zadanom direktoriju.");
            return;
        }
        File maxJavaFile = files.get(0);

        for(File file : files) {
            if(file.length() > maxJavaFile.length()) {
                maxJavaFile = file;
            }
        }

        System.out.printf("Staza : %s %n velicina : %d", maxJavaFile, maxJavaFile.length());
    }

    public static List<File> listaj(File path, Filter filter) {
        List<File> files = Arrays.asList(path.listFiles());
        if(files.size() == 0) {
            return files;
        }

        for(File file : files) {
            if(file.isDirectory()) {
                listaj(file, filter);
            }
            else {
                files.add(file);
            }
        }
        return files;
    }

    private static class Filter implements FilenameFilter {

        @Override
        public boolean accept(File dir, String name) {
            //System.out.printf("Pita me za: %s u direktoriju: %s %n", name, dir.getName());
            if(izvadiEkstenziju(name).equals("java")) return true;
            return false;
        }
    }

    private static String izvadiEkstenziju(String name) {
        int pozicija = name.lastIndexOf(".");
        if(pozicija < 1) return "";
        return name.substring(pozicija+1).toLowerCase();
    }
}
