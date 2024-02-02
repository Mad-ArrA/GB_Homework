package ru.gb.hm11.lesson11;

import java.util.ArrayList;
import java.util.Arrays;

public class eleven_1 {
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
        System.out.println("Задание 2. Преобразование массива в ArrayList.");
        System.out.println("Пример работы с числовым массивом.\n >>Начальный вид массива:");
        intArr.print();
        System.out.println(" >>Полученный ArrayList:\n" + intArr.arrayToArrayList() + "\n---------->");
        System.out.println("Пример работы со строковым массивом.\n >>Начальный вид массива:");
        stringArr.print();
        stringArr.arrayToArrayList();
        System.out.println(" >>Полученный ArrayList:\n" + stringArr.arrayToArrayList() + "\n---------->");
        System.out.println("Пример работы с массивом объектов.\n >>Начальный вид массива:");
        objectCatArr.print();
        objectCatArr.arrayToArrayList();
        System.out.println(" >>Полученный ArrayList:\n" + objectCatArr.arrayToArrayList() + "\n---------->");
        System.out.println(" >> P.S. Больше давать примеров смысла не вижу, т.к. у всех элементов массива есть " +
                "индексы, по которым можно\nнайти нужный элемент.");


    }
}
/**
 * Класс, объектом которого является массив. Изначально сделал все функции с обозначением "<T>", но потом(через кучу
 * ошибок после изменения кода, решил, что в конструкторе сразу буду передавать массив и в объекте сразу указывать
 * тип передаваемого массива
 * @param <T> универсальная переменная
 */
class ArrayTask1_2<T> {
    private T[] elements;

    public ArrayTask1_2(T[] elements) {
        this.elements = elements;
    }
    /**
     * Обобщённый метод для замены местами 2 элементов одномерного массива
     * P.S. думал сделать перегрузку метода, чтобы он работал как для одномерного массива, так и для многомерного, но
     * как я понял, придётся просто передавать больше индексов, а суть та же. А сделать общий метод не получится,
     * т.к. если массив двумерный, трёхмерный и т.д. Всё равно нужно будет каждый раз писать перегруженный метод.
     * @param index1 индекс первого элемента
     * @param index2 индекс второго элемента
     */
    public void reverseTwoElements(int index1, int index2 ) {
        T term = elements[index1];
        elements[index1] = elements[index2];
        elements[index2] = term;
    }

    public void print() {
        for (T element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    public ArrayList<T> arrayToArrayList(){
        return new ArrayList<>(Arrays.asList(elements));
    }
}

