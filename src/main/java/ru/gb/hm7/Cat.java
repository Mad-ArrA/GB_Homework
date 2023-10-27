package ru.gb.hm7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;


    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat(Plate p) {
        if (p.getFood() >= appetite) {
            p.decreaseFood(appetite);
            satiety = true;
        }
        else {
            System.out.println("В тарелке недостаточно еды для кота " + name);
        }
    }
    public void nameCat() {
        System.out.println("Кот " + name + (satiety ? " сыт" : " голоден"));
    }

}
