package com.scofevil.thinkingInJava.io;

import java.io.File;
import java.util.Arrays;

public class DirLIst2 {

    public static void main(final String[] args) {
        File path = new File("/Applications");
        System.out.println(path.isFile());
        String[] list;
        list = path.list();
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String string : list) {
            System.out.println(string);
        }
    }
}
