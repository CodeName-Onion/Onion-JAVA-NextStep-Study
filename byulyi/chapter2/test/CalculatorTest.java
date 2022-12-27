package com.example.stringcalculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("before");
    }

    @Test
    void add() {
        assertEquals(9, calculator.add(3, 6));
        System.out.println("add");
    }

    @Test
    void subtract() {
        assertEquals(3, calculator.subtract(6, 3));
        System.out.println("subtract");
    }

    @Test
    void multiply() {
        assertEquals(6, calculator.multiply(2, 3));
        System.out.println("multiply");
    }

    @Test
    @DisplayName("나누기 테스트")
    void divide() {
        assertEquals(2, calculator.divide(4, 2));
        System.out.println("divide");
    }

    @AfterEach
    void tearDown() {
        System.out.println("teardown \n");
    }

}