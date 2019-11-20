package ru.itsjava;

public class Game extends Object {
    public Game(String name) {
        this.name = name;
    }

    private String name;

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    private boolean isRented = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
