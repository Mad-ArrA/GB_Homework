package ru.gb.hm14.lesson;

public class Hm14 {
    public static int[] process1(int[] arr){
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("Входной массив не должен быть пустым");
        }

        /**
         * Перебираем элементы arr в обратном порядке, начиная с конца.
         * Если элемент равен 4, то сохраняем его индекс в переменной lastFourIndex.
         */
        int lastFourIndex = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4) {
                lastFourIndex = i;
                break;
            }
        }
        /**
         * Если lastFourIndex равен -1, то это означает, что в массиве не найдено ни одной четверки.
         * В этом случае вызывается RuntimeException с сообщением "Входной массив не содержит ни одной четверки".
         */
        if (lastFourIndex == -1) {
            throw new RuntimeException("Входной массив не содержит ни одной четверки");
        }

        /**
         * Создаем новый массив result размером arr.length - lastFourIndex - 1.
         * Копируем элементы arr из позиции lastFourIndex + 1 в result.
         */
        int[] result = new int[arr.length - lastFourIndex - 1];
        System.arraycopy(arr, lastFourIndex + 1, result, 0, result.length);

        return result;
    }

    public static boolean process2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        boolean hasOne = false;
        boolean hasFour = false;
        /**
         * Перебираем элементы arr.
         * Если элемент равен 1, то устанавливаем флаг hasOne в true.
         * Если элемент равен 4, то устанавливаем флаг hasFour в true.
         * Если элемент не равен 1 и 4, то возвращаем false.
         */
        for (int element : arr) {
            if (element == 1) {
                hasOne = true;
            } else if (element == 4) {
                hasFour = true;
            } else {
                return false;
            }
        }

        return hasOne && hasFour;
    }

}
