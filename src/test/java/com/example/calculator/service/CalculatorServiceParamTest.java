package com.example.calculator.service;

import com.example.calculator.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@SpringBootTest
public class CalculatorServiceParamTest {
    @Autowired
    private CalculatorService calculatorService;


// Провайдеры данных для тестов
    private static Stream<Arguments> provideAddData() {
        return Stream.of(
                Arguments.of(2, 2, 4),
                Arguments.of(-2, 2, 0)
        );
    }
    private static Stream<Arguments> provideSubtractData() {
        return Stream.of(
                Arguments.of(1, 1, 0),
                Arguments.of(-1, 1, -2)
        );
    }
    private static Stream<Arguments> provideMultiplyData() {
        return Stream.of(
                Arguments.of(1, 1, 1),
                Arguments.of(-1, 1, -1)
        );
    }
    private static Stream<Arguments> provideDivideData() {
        return Stream.of(
                Arguments.of(1, 1, 1),
                Arguments.of(-1, 1, -1)
        );
    }



    @ParameterizedTest
    @MethodSource("provideAddData")
    void addCorrectResult(double num1, double num2, double expected) {
        Assertions.assertEquals(expected, calculatorService.add(num1, num2));
    }
    @ParameterizedTest
    @MethodSource("provideSubtractData")
    void subtractCorrectResult(double num1, double num2, double expected) {
        Assertions.assertEquals(expected, calculatorService.subtract(num1, num2));
    }
    @ParameterizedTest
    @MethodSource("provideMultiplyData")
    void multiplyCorrectResult(double num1, double num2, double expected) {
        Assertions.assertEquals(expected, calculatorService.multiply(num1, num2));
    }
    @ParameterizedTest
    @MethodSource("provideDivideData")
    void divideCorrectResult(double num1, double num2, double expected) {
        Assertions.assertEquals(expected, calculatorService.divide(num1, num2));
    }
}
