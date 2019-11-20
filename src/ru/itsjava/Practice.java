package ru.itsjava;

public class Practice {
    public static void main(String[] args) {
        String name = "Гоша";
        System.out.println(name.charAt(0));
        System.out.println(name.length());
        System.out.println(name.contains("Го"));
        System.out.println(name.contains("ГГ"));
        System.out.println(name.replace("Гоша", "Виталик"));
    }

}
