package com.project.demo;
import com.project.demo.Math.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathLibTest {

    MathLib mathLib = new MathLib();

    @Test
    void testSqrt() {
        assertEquals(5.0, mathLib.sqrt(25), 0.001);
    }

    @Test
    void testFactorial() {
        assertEquals(120, mathLib.factorial(5));
    }

    @Test
    void testLn() {
        assertEquals(0.0, mathLib.ln(1), 0.001);
    }

    @Test
    void testPower() {
        assertEquals(8.0, mathLib.power(2, 3), 0.001);
    }
}
