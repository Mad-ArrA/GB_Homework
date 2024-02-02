package ru.gb.hm12.lesson12;

public class CounterThreadV2 implements Runnable {

    CommonResource res;

    CounterThreadV2(CommonResource res) {
        this.res = res;
    }


    @Override
    public void run() {

        res.increment();
        /*synchronized (res) {
            res.x = 1;
            for (int i = 0; i < 5; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
                res.x++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.getStackTrace();
                }
            }
        }*/

    }
}