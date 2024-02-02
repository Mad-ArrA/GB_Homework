package ru.gb.hm12.lesson12;

public class MyThread extends Thread {


    MyThread(String name){
        super(name);
    }

    public void run() {
        System.out.printf("Поток %s запущен ...\n", getName());

        try {
            Thread.sleep(10000); // 10 сек
        }
        catch (InterruptedException e){
            e.getStackTrace();
        }

        System.out.printf("Поток %s завершил свою работу ...\n", getName());
    }
}
