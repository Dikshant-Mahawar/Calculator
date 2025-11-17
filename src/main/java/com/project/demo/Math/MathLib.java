package com.project.demo.Math;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MathLib {

    private static final Logger logger = LoggerFactory.getLogger(MathLib.class);

    public double sqrt(double value) {
        logger.info("Computing sqrt for {}", value);

        if (value < 0) {
            logger.error("Invalid input for sqrt: {}", value);
            throw new IllegalArgumentException("Square root of negative number is undefined.");
        }

        double result = Math.sqrt(value);
        logger.info("Result of sqrt({}) = {}", value, result);
        return result;
    }

    public long factorial(int number) {
        logger.info("Computing factorial for {}", number);

        if (number < 0) {
            logger.error("Invalid input for factorial: {}", number);
            throw new IllegalArgumentException("Factorial of negative number is not defined.");
        }

        long fact = 1;
        for (int i = 1; i <= number; i++) {
            fact *= i;
        }

        logger.info("Result of factorial({}) = {}", number, fact);
        return fact;
    }

    public double ln(double value) {
        logger.info("Computing ln for {}", value);

        if (value <= 0) {
            logger.error("Invalid input for ln: {}", value);
            throw new IllegalArgumentException("Input must be positive for natural logarithm.");
        }

        double result = Math.log(value);
        logger.info("Result of ln({}) = {}", value, result);
        return result;
    }

    public double power(double base, double exponent) {
        logger.info("Computing power: {} ^ {}", base, exponent);

        double result = Math.pow(base, exponent);
        logger.info("Result of {} ^ {} = {}", base, exponent, result);

        return result;
    }
}
