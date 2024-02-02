package ru.gb.hm8;

public class Wall {
    private int length;

    public Wall(int length) {
        this.length = length;
    }

    public void pass(Run r){
        r.jump(length);
    }
}
