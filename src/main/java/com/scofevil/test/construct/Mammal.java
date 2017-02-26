package com.scofevil.test.construct;

class Mammal {
    void getBirthInfo() {
        System.out.println("born alive");
    }
}

class Platypus1 extends Mammal {
    void getBirthInfo() {
        System.out.println("hatch from eggs");
        System.out.println("a mammal normally is ");
        super.getBirthInfo();
    }
}
