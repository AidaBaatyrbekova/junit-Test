package peaksoft.junit_test.service;

import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {
    private CalculatorService calculatorService;


    @BeforeEach
    void init(){
        calculatorService = new CalculatorService();
    }

    @Test
    void sumTest(){

        int sum = calculatorService.sum(4,3);
        Assertions.assertEquals(7,sum);
    }

    @Test
    void evenTest(){
        boolean even = calculatorService.evenOrOdd(6);
        Assertions.assertTrue(even);
    }

    @Test
    void oddTest(){
        boolean odd = calculatorService.evenOrOdd(9);
        Assertions.assertFalse(odd);
    }

    @Test
    void divideTest(){
        Assertions.assertThrows(ArithmeticException.class, () ->calculatorService.divide(55,0));
    }

    @AfterEach
    void after(){
        System.out.println("After each "+this);
    }

}
