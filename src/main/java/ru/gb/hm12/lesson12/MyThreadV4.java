package ru.gb.hm12.lesson12;

public class MyThreadV4 implements Runnable {


    @Override
    public void run() {
        System.out.printf("Поток %s запущен ...\n", Thread.currentThread().getName());

        int counter = 1;


        while (!Thread.currentThread().isInterrupted()){
            System.out.println("Цикл " + counter++);

            try {
                Thread.sleep(60000);
            }
            catch (InterruptedException e){
                System.out.println("Выполнение потока было прервано.");
                break;
            }

        }

        System.out.printf("Поток %s завершил свою работу ...\n", Thread.currentThread().getName());
    }
}