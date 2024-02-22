package ru.gb.hm14.lesson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Sample02 {

    public static void main(String[] args) {


        try {
            System.setErr(new PrintStream(new File("sample.log")));
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

        System.err.println("Hello, GeekBrains!");
        System.err.println("Hello, GeekBrains!");

        try {

            throw new Exception("Произошло исключение.");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
