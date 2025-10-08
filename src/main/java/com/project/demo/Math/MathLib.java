package com.project.demo.Math;

public class MathLib {

// Computes the square root of a number
    public double sqrt(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Square root of negative number is undefined.");
        }
        return Math.sqrt(value);
    }

    // Calculates the factorial of an integer
    public long factorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Factorial of negative number is not defined.");
        }

        long fact = 1;
        for (int i = 1; i <= number; i++) {
            fact *= i;
        }
        return fact;
    }

    // Computes the natural logarithm
    public double ln(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Input must be positive for natural logarithm.");
        }
        return Math.log(value);
    }

    // Raises a base to a given exponent
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

}

