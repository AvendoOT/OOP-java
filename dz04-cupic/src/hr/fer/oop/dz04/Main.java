package hr.fer.oop.dz04;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    /***
     * Main method gets a string that is converted to path which leads to a directory
     * Program end if more than one path is given or it doesn't exists or if it leads to a file
     * If path corresponds to a directory - it prints a full path to the largest .java file in directory
     * and it's size
     * Program throws IOException if there is trouble connecting to input or output stream
     * @param args
     * @throws IOException
     */
    public static void main(String ... args) throws IOException {
        boolean flag = true;
        if (args.length != 1) {
            System.err.println("Enter one path!");
            flag = false;
        }
        if (flag) {
            String pathArg = args[0];
            Path path = Paths.get(pathArg);
            if (Files.notExists(path)) {
                System.err.println("Path doesn't exist !");
                flag = false;
            }
            File file = new File(String.valueOf(path));
            if (flag) {
                if (!file.isDirectory()) {
                    System.err.println("Path doesn't lead to a directory!");
                    flag = false;
                }
            }
            if (flag) {
                Long largestFileSize = 0L;
                int i = 0;
                int j = -1;
                for (File proxy : file.listFiles()) {
                    if (proxy.length() > largestFileSize && proxy.getName().endsWith(".java")) {
                        largestFileSize = proxy.length();
                        j = i;
                    }
                    i++;
                }
                if (j >= 0) {;
                    System.out.println("Java file located at  " + file.listFiles()[j].getAbsolutePath() + " is largest " +
                            "with size of  " + largestFileSize + "bytes" );
                }
                else System.err.println("There were no java files");
            }
        }



    }
}
