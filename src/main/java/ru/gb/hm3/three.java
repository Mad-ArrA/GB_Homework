package ru.gb.hm3;

import java.util.Random;
import java.util.Scanner;

public class three {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        menu();

    }

    static void menu(){
        System.out.print("Выберите номер задачи: \n");
        int noMenu = scan.nextInt();
        switch (noMenu){
            case 1:
                one();
                break;
            case 2:
                second();
                break;
            default:
                System.out.print("Неправильно далбаёб блять");
                break;
        }
    }

    /**
     * Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3
     * попытки угадать это число. При каждой попытке компьютер должен сообщить, больше ли
     * указанное пользователем число, чем загаданное, или меньше. После победы или проигрыша
     * выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
     */
    static void one(){
        Random rand = new Random();
        System.out.print("Я загадал новое число, готовься\n");
        int no = rand.nextInt(10);
            for (int i = 0; i < 3; i++) {
                int enter = scan.nextInt();
                if (no == enter) {
                    System.out.print("Выйгрыш\n");
                    yesOrNo();
                    break;
                }
                if (no > enter) {
                    System.out.print("Число больше\n");

                }
                if (no < enter) {
                    System.out.print("Число меньше\n");
                }
                if (i == 2){
                    yesOrNo();
                }

            }

    }
    static void yesOrNo(){
        System.out.print("Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет)\n");
        int chooise = scan.nextInt();
        switch (chooise){
            case 0:
                menu();
                break;
            case 1:
                one();
                break;
            default:
                System.out.println("-> Неверное значение. Попробуйте ещё раз!");
                yesOrNo();
        }
    }


    /**
     * Создать массив из слов
     * String[] words = {""apple"", ""orange"", ""lemon"", ""banana"", ""apricot"", ""avocado"", ""broccoli"", ""carrot"",
     * ""cherry"", ""garlic"", ""grape"", ""melon"", ""leak"", ""kiwi"", ""mango"", ""mushroom"", ""nut"", ""olive"", ""pea"",
     * ""peanut"", ""pear"", ""pepper"", ""pineapple"", ""pumpkin"", ""potato""}.
     * При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
     * сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь. Если
     * слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
     * apple – загаданное
     * apricot - ответ игрока
     * ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
     * Для сравнения двух слов посимвольно можно пользоваться:
     * String str = ""apple"";
     * char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
     * Играем до тех пор, пока игрок не отгадает слово.
     * Используем только маленькие буквы
     */
    static void second(){
        Random randStr = new Random();
        String[] arr2 = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int randIndex = randStr.nextInt(arr2.length);
        String randWord = arr2[randIndex];

        System.out.println("Угадайте загаданное слово!");

        while (true){
            System.out.print("Введите ваш ответ: ");
            String ans = scan.nextLine();

            if (ans.equals(randWord)){
                System.out.println("Поздравляю! Вы угадали слово: " + randWord);
                menu();
                break;
            }
            else {
                StringBuilder hint = new StringBuilder();
                for (int i = 0; i < randWord.length(); i++){
                    char wordQuest = randWord.charAt(i);
                    char worAns = (i < ans.length()) ? ans.charAt(i) : ' ';

                    if (wordQuest == worAns){
                        hint.append(wordQuest);
                    }
                    else {
                        hint.append("#");
                    }
                }
                while (hint.length() < 15) {
                    hint.append("#");
                }

                System.out.println("Подсказка: " + hint);
            }
        }

    }
}
