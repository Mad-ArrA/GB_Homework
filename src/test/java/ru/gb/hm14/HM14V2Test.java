package ru.gb.hm14;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.gb.hm14.lesson.Hm14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static ru.gb.hm14.lesson.Hm14.process2;

public class HM14V2Test {
    private Hm14 task1;

    @Test
    public void processArray1Test1(){
        int[] arr = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] actual = Hm14.process1(arr);

        int[] expected = {1, 7};

        Assertions.assertArrayEquals(expected, actual);

    }


        @ParameterizedTest
        @MethodSource("provideArrays")
        public void testProcess2(int[] arr, boolean expected) {
            Assertions.assertEquals(expected, process2(arr));
        }

        // Метод, предоставляющий поток параметров для теста
        private static Stream<Object[]> provideArrays() {
            return Stream.of(
                    new Object[]{new int[]{1, 4, 4, 1}, true},
                    new Object[]{new int[]{1, 4, 4, 4, 1}, true},
                    new Object[]{new int[]{1, 1, 1, 1}, false},
                    new Object[]{new int[]{4, 4, 4, 4}, false},
                    new Object[]{new int[]{1, 4, 3, 1}, false},
                    new Object[]{new int[]{}, false},
                    new Object[]{null, false}
            );
        }
}
