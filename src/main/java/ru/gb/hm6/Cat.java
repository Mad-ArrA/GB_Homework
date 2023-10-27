package ru.gb.hm6;

public class Cat extends Animal {

    static int counter;
    public Cat(String name) {
        super(name, "Кот", 200, 0);
        counter++;
    }
}
