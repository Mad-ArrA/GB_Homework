package ru.gb.hm12.lesson12;

public class MyThreadV2 implements Runnable {


    @Override
    public void run() {
        System.out.printf("Поток %s запущен ...\n", Thread.currentThread().getName());

        try {
            Thread.sleep(10000); // 10 сек
        }
        catch (InterruptedException e){
            e.getStackTrace();
        }

        System.out.printf("Поток %s завершил свою работу ...\n", Thread.currentThread().getName());
    }
}
