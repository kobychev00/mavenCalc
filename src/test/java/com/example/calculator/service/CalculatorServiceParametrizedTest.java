package com.example.calculator.service;

import com.example.calculator.TestUtils;
import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceParametrizedTest {

    private final CalculatorService calculatorService = new CalculatorService();

    public static Stream<Arguments> plusParams() {
        return Stream.of(
                Arguments.of("2", "2", TestUtils.formatResult(2, 2, "+", String.valueOf(2+2))),
                Arguments.of("45", "4", TestUtils.formatResult(45, 4, "+", String.valueOf(45+4))),
                Arguments.of("38", "1", TestUtils.formatResult(38, 1, "+", String.valueOf(38+1))),
                Arguments.of("0", "0", TestUtils.formatResult(0, 0, "+", String.valueOf(0+0)))
        );
    }

    @ParameterizedTest
    @MethodSource("plusParams")
    void plus(int num1, int num2, String result) {
        assertEquals(result, calculatorService.plus (num1 , num2));
    }

    public static Stream <Arguments> minusParams() {
        return Stream.of(
                Arguments.of("2", "2", TestUtils.formatResult(2, 2, "-", String.valueOf(2-2))),
                Arguments.of("45", "4", TestUtils.formatResult(45, 4, "-", String.valueOf(45-4))),
                Arguments.of("38", "1", TestUtils.formatResult(38, 1, "-", String.valueOf(38-1))),
                Arguments.of("0", "0", TestUtils.formatResult(0, 0, "-", String.valueOf(0-0)))
        );
    }

    @ParameterizedTest
    @MethodSource("minusParams")
    void minus(int num1, int num2, String result) {
        assertEquals(result, calculatorService.minus (num1 , num2));
    }

    public static Stream <Arguments> multiplyParams() {
        return Stream.of(
                Arguments.of("2", "2", TestUtils.formatResult(2, 2, "*", String.valueOf(2*2))),
                Arguments.of("45", "4", TestUtils.formatResult(45, 4, "*", String.valueOf(45*4))),
                Arguments.of("38", "1", TestUtils.formatResult(38, 1, "*", String.valueOf(38*1))),
                Arguments.of("0", "0", TestUtils.formatResult(0, 0, "*", String.valueOf(0*0)))
        );
    }
    @ParameterizedTest
    @MethodSource("multiplyParams")
    void multiply(int num1, int num2, String result) {
        assertEquals(result, calculatorService.multiply (num1 , num2));
    }

    public static Stream <Arguments> divideParams() {
        return Stream.of(
                Arguments.of("2", "2", TestUtils.formatResult(2, 2, "/", String.valueOf((double) 2/2))),
                Arguments.of("45", "4", TestUtils.formatResult(45, 4, "/", String.valueOf((double) 45/4))),
                Arguments.of("38", "1", TestUtils.formatResult(38, 1, "/", String.valueOf((double) 38/1))),
                Arguments.of("0", "1", TestUtils.formatResult(0, 1, "/", String.valueOf((double) 0/1))));
    }
    @ParameterizedTest
    @MethodSource("divideParams")
    void divide(int num1, int num2, String result) {
        assertEquals(result, calculatorService.divide (num1 , num2));
    }
}