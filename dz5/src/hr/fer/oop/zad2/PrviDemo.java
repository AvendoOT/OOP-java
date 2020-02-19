package hr.fer.oop.zad2;

import java.io.File;
import java.io.IOException;

public class PrviDemo {

    public static void main(String...args) throws IOException {
        File dir = new File(args[0]).getCanonicalFile();//uzima u obzir simbolicke linkove na linuxu
        FileUtilPrvi.obidiPodstablo(dir, new IspisPodstablaPrvi());
    }

}
