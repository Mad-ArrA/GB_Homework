package ru.gb.hm14;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import ru.gb.hm14.lesson.Homework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class HM14Test {
    private Homework calculator;

    @BeforeEach
    void setUp() {
        calculator = new Homework();
    }

    @ParameterizedTest
    @MethodSource("dataForAddOperation")
    public void testAddOperation(int a, int b, int result) {
        Assertions.assertEquals(result, calculator.add(a, b));
    }
    public static Stream<Arguments> dataForAddOperation() {
        List<Arguments> out = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            int a = (int)(Math.random() * 1000);
            int b = (int)(Math.random() * 1000);
            int result = a + b;
            out.add(Arguments.arguments(a, b, result));
        }
        return out.stream();
    }


    @CsvSource({
            "1, 1, 2",
            "2, 3, 5",
            "7, 5, 12",
            "12, 12, 24"
    })
    @ParameterizedTest
    public void massTestAdd(int a, int b, int result) {
        Assertions.assertEquals(result, calculator.add(a, b));
    }

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void testAdd() {
        /*Assertions.assertThrows(ArithmeticException.class, () -> {
// здесь должно появиться исключение
        });*/

        Assertions.assertEquals(4, calculator.add(2, 2));
    }
    @Test
    public void testSub() {
        Assertions.assertEquals(3, calculator.sub(5, 2));
    }
    @Test
    public void testMul() {
        Assertions.assertEquals(9, calculator.mul(3, 3));
    }

    @Test
    @Disabled("Деление пока тестировать не нужно")
    public void testDiv() {
        Assertions.assertEquals(1, calculator.div(2, 2));
    }

}
