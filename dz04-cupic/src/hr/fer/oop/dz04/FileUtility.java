package hr.fer.oop.dz04;

import java.io.File;

public class FileUtility {

    public static void subTreeTraversal(File dir, Processing proc) {

        if (!proc.enteringDirectory(dir)) return;
        File[] children = dir.listFiles();
        if(children == null) return;

        for(File child : children) {
            if(child.isDirectory()) {
                subTreeTraversal(child, proc);
            } else {
                proc.foundFile(child);
            }
        }

        if (!proc.exitingDirectory(dir)) return;
    }
}
