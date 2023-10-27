package ru.gb.hm6;

public class Dog extends Animal{
    static int counter;
    public Dog(String name) {
        super(name, "Собака", 500, 10);
        counter++;
    }
}
