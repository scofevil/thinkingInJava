package com.scofevil.test.enumt;

public enum Color {
    RED("red", 1),
    GREEN("green", 2),
    YELLOW("yellow", 3);
    private String name;
    private int    id;

    Color(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
