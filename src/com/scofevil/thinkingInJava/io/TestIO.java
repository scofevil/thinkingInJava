package com.scofevil.thinkingInJava.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestIO {
    public static void main(String[] args) {
        File file = new File("." + File.separator + "pom.xml");
        File file1 = new File(".");
        for (String each : file1.list()) {
            System.out.println(each);
        }
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        byte[] b = new byte[1000];
        try {
            int start = 0;
            int len = 10;
            while (fis.read(b, start, len) > 0) {
                start = start + len;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStreamReader isr = new InputStreamReader(fis);
        char[] cbuf = new char[1000];
        int offset = 0;
        int length = 10;
        try {
            while (isr.read(cbuf, offset, length) > 0) {
                offset = offset + length;
                System.out.println(cbuf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
