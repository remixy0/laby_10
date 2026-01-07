package org.example.Zad1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CalculatorTest {

    @Test
    public void dodawaniePowinnoZwrocicSume() {
        int a = 4;
        int b = 2;

        double wynik = Calculator.divide(a,b);

        assertThrows(ArithmeticException.class, () -> {
            Calculator.divide(10, 0);
        });


        assertEquals(2, wynik, 2);

    }

}
