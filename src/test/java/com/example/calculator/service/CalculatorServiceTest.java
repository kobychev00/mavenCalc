package com.example.calculator.service;
import com.example.calculator.TestUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    void greeting_success() {
        //Подготовка ожиданиемого результата
        String expectedMessage = "Добро пожаловать в калькулятор!";
        //Подготовка тестов
        String actualMessage = calculatorService.greeting();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void plus_success() {
        // Подготовка входных данных
        int num1 = 3;
        int num2 = 9;
        // Подготовка ожидаемового результат
        String exceptedResult = TestUtils.formatResult(num1, num2, "+", String.valueOf(num1+num2));
        // Подготовка тестов
       String actualResult = calculatorService.plus(num1, num2);
        assertEquals(exceptedResult, actualResult);
    }

    @Test
    void plus_success2() {
        // Подготовка входных данных
        int num1 = 52;
        int num2 = 4;
        // Подготовка ожидаемового результат

        // Подготовка тестов


    }

    @Test
    void minus_success() {
        // Подготовка входных данных
        int num1 = 3;
        int num2 = 2;
        // Подготовка ожидаемового результата
        String expectedResult = TestUtils.formatResult(num1, num2, "-", String.valueOf(num1 - num2));
        // Подготовка тестов
        String actualResult = calculatorService.minus(num1, num2);
        assertEquals(expectedResult, actualResult);

    }

    @Test
    void multiply_success() {
        // Подготовка входных данных
        int num1 = 23;
        int num2 = 6;
        // Подготовка ожидаемового результата
        String exceptedResult = TestUtils.formatResult(num1, num2, "*", String.valueOf(num1 * num2));
        // Подготовка тестов
        String actualResult = calculatorService.multiply(num1, num2);
        assertEquals(exceptedResult, actualResult);
    }

    @Test
    void divide_success() {
        // Подготовка входных данных
        int num1 = 56;
        int num2 = 8;
        // Подготовка ожидаемового результата
        String expectedResult = TestUtils.formatResult(num1, num2, "/", String.valueOf((double) num1 / num2));
        // Подготовка тестов
        String actualResult = calculatorService.divide(num1, num2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void divide_withException() {
        // Подготовка входных данных
        int num1 = 34;
        int num2 = 0;
        // Подготовка ожидаемового результата
        String expectedMessage = "На ноль делить нельзя!";

        // Подготовка тестов
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculatorService.divide(num1, num2)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }
}