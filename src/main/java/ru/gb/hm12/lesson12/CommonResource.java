package ru.gb.hm12.lesson12;

public class CommonResource {

    int x = 0;

    synchronized void increment(){

        x = 1;
        for (int i = 0; i < 5; i++) {
            System.out.printf("%s %d \n", Thread.currentThread().getName(), x);
            x++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
        }

    }


}
