package hr.fer.oop.zad2;

import java.io.File;
import java.io.IOException;

public class DrugiDemo {
    public static void main(String...args) throws IOException {
        File dir = new File(args[0]).getCanonicalFile();//uzima u obzir simbolicke linkove na linuxu
        FileUtilDrugi.obidiPodstablo(dir, new IspisPodstablaDrugi());
    }
}
