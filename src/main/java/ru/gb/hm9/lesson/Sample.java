package ru.gb.hm9.lesson;

import java.util.Random;

public class Sample {

    public static void main(String[] args) {
        Animal cat = new Cat("Жора");
        Random random = new Random();
        for(int i=0; i < 10; i++){
            int j = random.nextInt(2);
            try {
                switch (j){
                    case 0:
                        if(cat.swim(i*10))
                            System.out.printf("Котик успешно проплыл %d метров\n\n", i*10);
                        break;
                    case 1:

                        if(cat.run(i*10))
                            System.out.printf("Котик успешно пробежал %d метров\n\n", i*10);
                        break;
                }
            }
            catch (AnimalSwimException e){
                System.out.printf("Ошибка при попытке %s проплыть %d метров\n%s\n\n", e.getName(), e.getDistance(), e.getMessage());
            }
            catch (AnimalRunException e) {
                System.out.printf("Ошибка при попытке %s пробежать %d метров\n%s\n\n", e.getName(), e.getDistance(), e.getMessage());
            }
        }
    }
}
abstract class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }
    abstract boolean swim(int distance) throws AnimalSwimException;

    abstract boolean run(int distance) throws AnimalRunException;
}

class Cat extends Animal{

    public Cat(String name) {
        super(name);
    }

    @Override
    boolean swim(int distance) throws AnimalSwimException{
        throw new AnimalSwimException("Котик не умеет плавать.", name, distance);
    }

    @Override
    boolean run(int distance) throws AnimalRunException{
        if (distance > 50){
            throw new AnimalRunException("Котику тяжело бегать.", name, distance);
        }
        return true;
    }
}

class AnimalRunException extends AnimalException{

    public AnimalRunException(String message, String name, int distance) {
        super(message, name, distance);
    }
}

class AnimalSwimException extends AnimalException{

    public AnimalSwimException(String message, String name, int distance) {
        super(message, name, distance);
    }
}

abstract class AnimalException extends Exception{

    private String name;
    private int distance;

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public AnimalException(String message, String name, int distance){
        super(message);
        this.name = name;
        this.distance = distance;
    }
}