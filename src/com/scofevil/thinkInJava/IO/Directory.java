package com.scofevil.thinkInJava.IO;

import java.io.File;
import java.io.FilenameFilter;

public final class Directory {
    public static File[] local(File dir, final String regex) {
        return dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return true;
            }
        });
    }

    public static File[] local(String path, final String regex) {
        return local(new File(path), regex);
    }

    public static void main(String[] args) {
        System.out.println(TreeInfo.walk("/dev"));
    }

}
