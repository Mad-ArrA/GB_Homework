package ru.gb.hm11.lesson11;

public class eleven_2 {
    static Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    static String[] stringArray = {"Апельсин", "Съел", "Петя"};
    static JustAcat[] objectCatArray = {
            new JustAcat("Мурзик"),
            new JustAcat("Тузик"),
            new JustAcat("Семён"),
            new JustAcat("Пушок")
    };
    static ArrayTask1_2<Integer> intArr = new ArrayTask1_2<>(intArray);
    static ArrayTask1_2<String> stringArr = new ArrayTask1_2<>(stringArray);
    static ArrayTask1_2<JustAcat> objectCatArr = new ArrayTask1_2<>(objectCatArray);
    public static void main(String[] args) {

        System.out.println("Задание 1. Замена элементов местами в любом строковом массиве.\n");
        System.out.println("Пример работы с числовым массивом.\n >>Начальный вид массива:");
        intArr.print();
        intArr.reverseTwoElements( 0, 8);
        System.out.println(" >>Массив после обработки:");
        intArr.print();
        System.out.println("\n---------->");
        System.out.println("Пример работы со строковым массивом.\n >>Начальный вид массива:");
        stringArr.print();
        stringArr.reverseTwoElements( 0, 1);
        System.out.println(" >>Массив после обработки:");
        stringArr.print();
        System.out.println("\n---------->");
        System.out.println("Пример работы с массивом объектов.\n >>Начальный вид массива:");
        objectCatArr.print();
        objectCatArr.reverseTwoElements( 0, 2);
        System.out.println(" >>Массив после обработки:");
        objectCatArr.print();
        System.out.println("\n---------->");
        System.out.println(" >> P.S. Больше давать примеров смысла не вижу, т.к. у всех элементов массива есть " +
                "индексы, по которым можно\nнайти нужный элемент.");

    }

}
class JustAcat {
    private String name;

    public String getName() {
        return name;
    }

    public JustAcat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s", name);
    }
}