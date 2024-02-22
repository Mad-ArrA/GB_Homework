package ru.gb.hm13;

import java.util.Random;

public class Sample01 {

    public static void main(String[] args) {

        Plate plate = new Plate();
        Human human = new Human(plate);
        Cat cat1 = new Cat(plate);
        Cat cat2 = new Cat(plate);

        new Thread(human).start();
        new Thread(cat1, "cat #1").start();
        new Thread(cat2, "cat #2").start();

    }

}

class Plate{

    private int food = 0;

    public static Random random = new Random();

    public  synchronized  void get(String name){
        while (food < 1){
            try {
                wait();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        food--;
        System.out.printf("Кот %s покушал еду из миски\n", name);
        System.out.println("Еды в миске: " + food);
        notify();
    }

    public synchronized void put(){
            while (food >= 3){
                try {
                    wait();
                    Thread.sleep(random.nextInt(500));
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            food++;

        System.out.println("Человек добавил еду в миску.");
        System.out.println("Еды в миске: " + food);
        notifyAll();
    }

}

class Human implements Runnable{

    Plate plate;

    public Human(Plate plate) {
        this.plate = plate;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            plate.put();
        }
        System.out.printf("У человека закончилась еда ...\n");
    }

}

class Cat implements  Runnable{

    Plate plate;

    public Cat(Plate plate) {
        this.plate = plate;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            plate.get(Thread.currentThread().getName());
        }
        System.out.printf("Кот %s наелся ...\n", Thread.currentThread().getName());

    }
}
