package hr.fer.oop.dz04;

import java.io.File;

public interface Processing {

    default boolean enteringDirectory(File dir) {
        if (!dir.isDirectory()) return false;
        return true;
    }
    default boolean exitingDirectory(File dir) {
        if (!dir.isDirectory()) return false;
        return true;
    }
    void foundFile(File file);
}
