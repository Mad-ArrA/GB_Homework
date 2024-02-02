package ru.gb.hm12.lesson12;

public class Sample03 {


    public static void main(String[] args) {

        CommonResource res = new CommonResource();
        CounterThread counterThread = new CounterThread(res);

        //Thread t = new Thread(counterThread, "thread #1");
        //t.start();


        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++){
            threads[i] = new Thread(new CounterThreadV2(res), "thread #" + i);
            threads[i].start();
        }


    }

}
