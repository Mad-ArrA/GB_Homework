package ru.gb.hm2;

import java.util.Arrays;
import java.util.Random;

public class second {
    public static void main(String[] args) {
    zero();
    first();
    second();
    three();
    four();
    five();

    int[] arr6 = {2, 2, 2, 1, 2, 2, 10, 1};
    boolean sixResult = six(arr6);
    System.out.print(sixResult);

    seven();
    }

    /**
     * Бинарный поиск
     */
    static void zero(){
        System.out.println();
        System.out.print("Задание 0: ");
        int e = -8;
        int[] arr0 = {-10, 24, 2, 18, -8};
        Arrays.sort(arr0);
        System.out.println(Arrays.toString(arr0) + " ");
        int res0 = Arrays.binarySearch(arr0, e);
        System.out.printf("Искомый элемент %d найден по индексу %d", e, res0);
        System.out.println();
    }

    /**
     * Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
     * С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
    static void first() {
        System.out.println();
        System.out.print("Задание 1: \n");
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 0){
                arr[i] = 1;
            }
            else {
                arr[i] = 0;
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
     */
    static void second(){
        System.out.println();
        System.out.print("Задание 2: \n");
        int[] arr2 = new int[8];
        for (int i = 0; i < arr2.length; i++ ){
            arr2[i] = i * 3;
                System.out.print(arr2[i] + " ");
        }
        System.out.println();
    }

    /**
     * Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
     */
    static void three(){
        System.out.println();
        System.out.print("Задание 3: \n");
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++){
            if (arr3[i] < 6){
                arr3[i] *= 2;
            }
            System.out.print(arr3[i] + " ");
        }
        System.out.println();
    }

    /**
     * Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
     * и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
     */
    static void four(){
        System.out.println();
        System.out.print("Задание 4: \n");

        Random random = new Random();
        int[][] arr4 = new int[3][3];

        for (int i = 0; i < arr4.length; i++){
            for (int j = 0; j < arr4[i].length; j++){
                if (j == i){
                    arr4[i][j]=1;
                }
                System.out.print(arr4[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
     */
    static void five() {
        System.out.println();
        System.out.print("Задание 5: \n");
        Random random = new Random();
        int[] arr5 = new int[5];

        for (int i = 0; i < arr5.length; i++) {
            arr5[i] = random.nextInt(10);
            System.out.print(arr5[i] + " ");
        }

        int eX = 0;
        int eY = 0;
        int max = arr5[eX];
        int min = arr5[eY];
        for (int i = 0; i < arr5.length; i++){
            if (arr5[i] > max){
                max = arr5[i];
                eX = i;
            }
            if (arr5[i] < min){
                min = arr5[i];
                eY = i;
            }
        }
        System.out.println();
        System.out.printf("Индекс макс. элемента массива: [%d]\n" , eX);
        System.out.println("Значение макс. элемента: " + max);
        System.out.printf("Индекс мин. элемента массива: [%d]\n" , eY);
        System.out.println("Значение мин. элемента: " + min);
    }

    /**
     * Написать метод, в который передается не пустой одномерный целочисленный массив,
     * метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
     * Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
     * граница показана символами ||, эти символы в массив не входят.
     */
    static boolean six(int[] arr6){
        System.out.println();
        System.out.print("Задание 6: \n");
        int sum = 0;
        for (int i = 0; i < arr6.length; i++){
            sum += arr6[i];
        }

        if (sum % 2 != 0){
            return false;
        }
        sum /= 2;
        int left = 0;
        for (int i : arr6) {
            left += i;
            if (left == sum) return true;
            if (left > sum) return false;
        }

        return false;
    }

    /**
     * Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
     * при этом метод должен сместить все элементы массива на n позиций.
     * Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
     * Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево)
     * -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
     */
    static void seven(){
        System.out.println();
        System.out.print("Задание 7: \n");
        int[] arr7 = {2, 3, 4, 1, 8, 14, 5, 10, 13};
        int n = 15;
        int shift = (arr7.length + n % arr7.length) % arr7.length; // Вычисляем реальное смещение
        for (int i = 0; i < shift; i++) { // Выполним цикл смещения по одному элементу в соответствии с значенимем реального смещения (переменная shift)
            int temp = arr7[arr7.length - 1]; // Сохраняем значение ПОСЛЕДНЕГО элемента массива
            for (int j = arr7.length - 1; j > 0 ; j--) { // Пройдем по всем элементам массива с конца в начало, заменим значение текущего элемента массива значением элемента, предшествующего текущему
                arr7[j] = arr7[j - 1];
            }
            arr7[0] = temp; // А как быть с самым первым элементом? Вот как раз из переменной temp мы и получим недостающее значение
        }
        for (int r = 0; r< arr7.length;r++){
            System.out.print(arr7[r] + " ");
        }
    }

}
