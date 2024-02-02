package ru.gb.hm12.lesson12;

public class Sample01 {

    public static void main(String[] args) {
        System.out.println("Начало работы приложения ...");

        Thread t = Thread.currentThread();
        System.out.println(t.getName());
        System.out.println(t.getPriority());
        //t.setPriority();

        //MyThread myThread01 = new MyThread("myThread");
        //myThread01.start();



       /* MyThread[] myThreads = new MyThread[6];
        for (int i = 0; i < myThreads.length; i++){
            myThreads[i] = new MyThread("myThread #" + i);
            myThreads[i].start();
        }


        try {
            for (MyThread thread : myThreads) {
                thread.join();
            }

        }

        */

        Thread[] myThreads = new Thread[6];
        for (int i = 0; i < myThreads.length; i++){
            myThreads[i] = new Thread(new MyThreadV2(), "thread#" + i);
            myThreads[i].start();
        }

        try {
            for (Thread thread : myThreads) {
                thread.join();
            }

        }
        catch (InterruptedException e){
            e.getStackTrace();
        }



        System.out.println("Завершение работы приложения ...");
    }



}
