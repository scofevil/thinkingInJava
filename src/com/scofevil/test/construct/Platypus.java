package com.scofevil.test.construct;

class Platypus {
    String name;

    Platypus(String input) {
        name = input;
    }

    Platypus() {
        this("John/Mary Doe");
    }

    public static void main(String[] args) {
        Platypus p1 = new Platypus("digger");
        Platypus p2 = new Platypus();
        System.out.println(p1.name + "---" + p2.name);
    }
}
