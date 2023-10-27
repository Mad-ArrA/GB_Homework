package ru.gb.hm7;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public void decreaseFood(int n) {
        if (n > food){
            food = 0;
        }
        else {
            food -= n;
        }
    }

    public int getFood() {
        return food;
    }

    public void info() {
        System.out.println("Тарелка: " + food);
    }
    public void addFood(int n) {
        food += n;
    }
}
