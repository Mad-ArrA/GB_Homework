package ru.gb.hm12.lesson12;

public class Sample02 {


    public static void main(String[] args) {
        System.out.println("Начало работы приложения ...");

        /*MyThreadV3 myThreadV3 = new MyThreadV3();
        new Thread(myThreadV3, "thread #1").start();


        try {
            Thread.sleep(3000);
            myThreadV3.disable();
            Thread.sleep(3000);
        }
        catch (InterruptedException e){
            e.getStackTrace();
        }*/

        MyThreadV4 myThreadV4 = new MyThreadV4();
        Thread t =  new Thread(myThreadV4, "thread #1");
        t.start();


        try {
            Thread.sleep(3000);
            t.interrupt();
            Thread.sleep(3000);
        }
        catch (InterruptedException e){
            e.getStackTrace();
        }


        System.out.println("Завершение работы приложения ...");
    }

}
