package ru.gb.hm8;

public abstract class Treadmill {
    int length;

    public Treadmill(int length) {
        this.length = length;
    }

    public void pass(Run r){
        r.run(length);
    }

}
