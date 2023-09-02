package com.example.calculator.service;

import com.example.calculator.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorServiceTest {

    @Autowired
    private CalculatorService calculatorService;

    @Test
    void addTest() {
        Assertions.assertEquals(4, calculatorService.add(2, 2));
        Assertions.assertEquals(0, calculatorService.add(-2, 2));

    }

    @Test
    void subtractTest() {
        Assertions.assertEquals(0, calculatorService.subtract(2, 2));
        Assertions.assertEquals(-4, calculatorService.subtract(-2, 2));
    }

    @Test
    void multiplyTest() {
        Assertions.assertEquals(4, calculatorService.multiply(2, 2));
        Assertions.assertEquals(-4, calculatorService.multiply(-2, 2));
    }

    @Test
    void divideTest() {
        Assertions.assertEquals(1, calculatorService.multiply(2, 2));
        Assertions.assertEquals(-1, calculatorService.multiply(-2, 2));
    }

    @Test
    void divideByZeroTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(2, 0));

    }
}

