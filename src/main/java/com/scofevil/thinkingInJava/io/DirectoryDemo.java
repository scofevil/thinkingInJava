package com.scofevil.thinkingInJava.io;

import com.scofevil.thinkingInJava.util.Directory;
import com.scofevil.thinkingInJava.util.PPrint;

import java.io.File;

public class DirectoryDemo {
    public static void main(String[] args) {
        PPrint.pprint(Directory.walk(".").dirs);
        for (File each : Directory.local(".", "T.*"))
            System.out.println(each);
        System.out.println("-----------------");
        for (File each : Directory.walk(".", "T.*\\.java"))
            System.out.println(each);
        System.out.println("=================");
        for (File each : Directory.walk(".", ".*[Zz].*\\.class"))
            System.out.println(each);
    }
}
