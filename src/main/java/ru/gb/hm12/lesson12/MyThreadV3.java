package ru.gb.hm12.lesson12;

public class MyThreadV3 implements Runnable {

    private boolean isActive;

    MyThreadV3(){
        isActive = true;
    }

    void disable(){
        isActive = false;
    }

    @Override
    public void run() {
        System.out.printf("Поток %s запущен ...\n", Thread.currentThread().getName());

        int counter = 1;


        while (isActive){
            System.out.println("Цикл " + counter++);

            try {
                Thread.sleep(15000);
            }
            catch (InterruptedException e){
                System.out.println("Выполнение потока было прервано.");
            }

        }

        System.out.printf("Поток %s завершил свою работу ...\n", Thread.currentThread().getName());
    }
}
