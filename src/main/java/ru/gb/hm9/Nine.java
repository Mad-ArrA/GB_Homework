package ru.gb.hm9;

import java.util.Random;

/**
 * 1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При
 * подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 * 2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и
 * просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
 * ячейке лежит символ или текст вместо числа), должно быть брошено исключение
 * MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
 * 3 В методе main() вызвать полученный метод, обработать возможные исключения
 * MyArraySizeException и MyArrayDataException и вывести результат расчета.
 */
public class Nine {
    public static void main(String[] args) {

    }
    public void Task1(String[][] arr) throws MyArrayDataException, MyArraySizeException{

    }
}
abstract class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}
abstract class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}



