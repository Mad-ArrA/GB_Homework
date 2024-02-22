package ru.gb.hm13;

import java.util.concurrent.Semaphore;

public class Sample02 {


    public static void main(String[] args) {

        /*Semaphore semaphore = new Semaphore(1);

        SampleClass sampleClass = new SampleClass();

        new Thread(new MyThread(sampleClass, semaphore), "thread #1").start();
        new Thread(new MyThread(sampleClass, semaphore), "thread #2").start();
        new Thread(new MyThread(sampleClass, semaphore), "thread #3").start();
        new Thread(new MyThread(sampleClass, semaphore), "thread #4").start();
        new Thread(new MyThread(sampleClass, semaphore), "thread #5").start();*/


        Semaphore semaphore1 = new Semaphore(3);
        for (int i = 0; i < 7; i++) {
            new CatV2(semaphore1, i + 1).start();
        }

    }

}

class SampleClass{

    int a = 0;

}

class CatV2 extends Thread{

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m";
    Semaphore semaphore;
    int num = 0;

    public CatV2(Semaphore semaphore, int i) {
        super("Cat #" + i);
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            while (num < 3) {
                semaphore.acquire();

                System.out.printf("%s %sподходит%s к миске, начинает кушать ...\n", getName(), GREEN_BOLD_BRIGHT, ANSI_RESET);


                sleep(1500);
                num++;

                System.out.printf("%s %sотходит%s от миски, сытость %d/3\n", getName(),RED_BOLD_BRIGHT, ANSI_RESET, num);

                semaphore.release();
                sleep(500);
            }

        }
        catch (InterruptedException e){
            e.printStackTrace();
        }






    }
}

class MyThread implements Runnable{

    SampleClass sampleClass;
    Semaphore semaphore;

    public MyThread(SampleClass sampleClass, Semaphore semaphore) {
        this.sampleClass = sampleClass;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(); // 1
            sampleClass.a = 1;
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + sampleClass.a);
                sampleClass.a++;
                Thread.sleep(100);
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        semaphore.release(); // 1
    }
}
