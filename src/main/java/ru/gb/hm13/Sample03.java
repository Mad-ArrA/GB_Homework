package ru.gb.hm13;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Sample03 {

    public static void main(String[] args) {
        System.out.println("Начало работы главного потока.");
        Random random = new Random();
        int count = 2;
        CountDownLatch countDownLatch = new CountDownLatch(count);

        for (int i = 0; i < 5; i++){
            new Thread(new MyThredV2(random.nextInt(500), countDownLatch)).start();
        }

        try {
            countDownLatch.await();
            System.out.printf("Мы дождались завершения %d потоков.\nДругие потоки, возможно, все еще работают.\n",
                    count);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }


        System.out.println("Начало работы главного потока.");
    }

}

class MyThredV2 implements Runnable{

    int millis;
    CountDownLatch countDownLatch;


    public MyThredV2(int millis, CountDownLatch countDownLatch) {
        this.millis = millis;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.printf("Поток %s запущен.\n", Thread.currentThread().getName());
            Thread.sleep(millis);
            System.out.printf("Поток %s завершен.\n", Thread.currentThread().getName());
            countDownLatch.countDown();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
