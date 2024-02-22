package ru.gb.hm14.lesson;

public class Sample {

    private static Sample s;

    public static Sample get(){
        if (s == null)
            s = new Sample();
        return s;
    }





}
