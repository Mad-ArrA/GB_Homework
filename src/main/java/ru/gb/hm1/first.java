package ru.gb.hm1;

public class first {

    public static void main(String[] args) {   //1
        float a = 12.55F;
        float b = 10;
        float c = 1.12F;
        float d = 7.77F;

        float sum = third(a,b,c,d);
        System.out.println("Результат выражения: " + sum);


        int x = 15;
        int y = 6;
        boolean sum4 = four(x,y);
        System.out.println(sum4);

        five(-4);

        int p = -5;
        boolean sum6 = six(p);
        System.out.println(sum6);

        seven("Аркадий");

        int g = 2000;
        eight(g);
    }

    static void second(){
        byte myByte = 10; //byte: 8-битное целое число (от -128 до 127).
        short myShort = 1000; //short: 16-битное целое число (от -32,768 до 32,767).
        int myInt = 1000000; //int: 32-битное целое число (от -2,147,483,648 до 2,147,483,647).
        long myLong = 1000000000L; //long: 64-битное целое число (от -9,223,372,036,854,775,808 до 9,223,372,036,854,775,807). (обратите внимание на суффикс "L" для указания типа)
        float myFloat = 3.14f; //float: 32-битное число с плавающей запятой. (обратите внимание на суффикс "f" для указания типа)
        double myDouble = 3.14159; //double: 64-битное число с плавающей запятой.
        char myChar = 'A'; //char: 16-битный символ Unicode.
        boolean myBoolean = true; //boolean: логическое значение true или false.
        String myString = "Привет, мир!"; //String: строковый тип данных.
    }

    static float third(float a, float b, float c, float d){
        float res = a*(b+(c/d));
        return res;
    }


    static boolean four(int x, int y){
        int fourSum = x+y;
        if (fourSum >= 10 && fourSum <= 20){
            return true;
        }
        return false;
    }

    static void five(int z){
        if (z >= 0){
            System.out.println("Положительное число");
        }
        else {
            System.out.println("Отрицательные");
        }
    }

    static boolean six(int p){
        if (p >= 0){
            return false;
        }
        return true;
    }

    static void seven(String s){
        String hi = "Привет, ";
        System.out.println(hi + s);
    }

    static void eight(int g){
        if (g % 4 == 0 && g % 100 == 0 && g % 400 == 0){
            System.out.println("Високосный");
        }
        else {
            System.out.println("Невисокосный");
        }
    }
}
