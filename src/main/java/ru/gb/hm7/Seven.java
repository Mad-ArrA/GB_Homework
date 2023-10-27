package ru.gb.hm7;

import java.util.Scanner;

/**
 * Расширить задачу про котов и тарелки с едой.
 * Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20).
 * Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
 * Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
 * Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.
 * Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
 */
public class Seven {

    public static void main(String[] args) {

        Cat[] cat = {
                new Cat("Barsik", 5),
                new Cat("Жора", 10)
        };
        Plate plate = new Plate(10);
        for (Cat c: cat) {
            plate.info();
            c.eat(plate);
            plate.info();
            c.nameCat();
            System.out.println();
        }

        plate.addFood(10);

        for (Cat c: cat) {
            plate.info();
            c.eat(plate);
            plate.info();
            c.nameCat();
            System.out.println();
        }



        //alphabet();

    }

    /**
     * Сколько символов в массиве
     */
    public static void alphabet(){
        Scanner scanner = new Scanner(System.in);
        //создаём массив
        int[] statistict = new int[26]; // кол-во символов латинского алфавита

        int cA = 'a'; // начальный символ - 97
        System.out.println("Введите строку: ");
        String s = scanner.nextLine();
        s = s + ".";

        char c;
        char i = 0;
        int k;

        do {
            c = s.charAt(i); // charAt может вернуть по индексу нужный нам элемент
            k = c; // получаем код символа Unicode
            if (c >= 'a' && c <= 'z'){
                statistict[k - cA]++; // вычитаем числовое значение кода
            }
            i++;
        }
        while (c != '.');
        System.out.println("Результат работы программы: ");
        for (int j = 0; j < 26; j++)
            if (statistict[j] > 0){
                System.out.printf("%s%d\n",(char)(j + cA), statistict[j]);
            }
        scanner.close();
    }
}
