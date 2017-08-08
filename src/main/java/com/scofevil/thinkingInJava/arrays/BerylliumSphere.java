package com.scofevil.thinkingInJava.arrays;

public class BerylliumSphere {
    static long counter;
    private final long id = counter++;

    public String toString() {
        return "Sphere " + id;
    }
}
