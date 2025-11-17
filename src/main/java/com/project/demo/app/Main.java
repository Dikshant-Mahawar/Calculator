package com.project.demo.app;

import com.project.demo.Math.*;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    
    //New webhook

    // Add new webhooks --- 

    // Add new webhook for check

    
    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        logger.info("Calculator application started");
        Scanner input = new Scanner(System.in);
        MathLib calculator = new MathLib();
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Select an option: ");

            int option = input.nextInt();
            logger.info("User selected option {}", option);

            try {
                switch (option) {
                    case 1 -> {
                        logger.info("Square Root operation selected");
                        handleSquareRoot(input, calculator);
                    }
                    case 2 -> {
                        logger.info("Factorial operation selected");
                        handleFactorial(input, calculator);
                    }
                    case 3 -> {
                        logger.info("Logarithmic operation selected");
                        handleLogarithm(input, calculator);
                    }
                    case 4 -> {
                        logger.info("Power operation selected");
                        handlePower(input, calculator);
                    }
                    case 5 -> {
                        logger.info("User chose to exit");
                        System.out.println("Thank you for using the calculator. Goodbye!");
                        running = false;
                    }
                    default -> {
                        logger.warn("Invalid option selected: {}", option);
                        System.out.println("Invalid option. Please try again.");
                    }
                }
            } catch (Exception e) {
                logger.error("Exception occurred: {}", e.getMessage());
                System.out.println("An error occurred: " + e.getMessage());
            }






            System.out.println();
        }
        logger.info("Calculator application stopped");
        input.close();
    }

    private static void displayMenu() {
        System.out.println("================= Scientific Calculator =================");
        System.out.println("1. Square Root");
        System.out.println("2. Factorial");
        System.out.println("3. Natural Logarithm");
        System.out.println("4. Power Function");
        System.out.println("5. Exit");
        System.out.println("==========================================================");
    }

    private static void handleSquareRoot(Scanner sc, MathLib lib) {
        System.out.print("Enter a number: ");
        double num = sc.nextDouble();
        logger.info("Handling sqrt for input {}", num);
        double result = lib.sqrt(num);
        logger.info("Sqrt result for {} is {}", num, result);
        System.out.println("√" + num + " = " + result);
    }

    private static void handleFactorial(Scanner sc, MathLib lib) {
        System.out.print("Enter an integer: ");
        int n = sc.nextInt();
        logger.info("Handling factorial for input {}", n);
        long result = lib.factorial(n);
        logger.info("Factorial result for {} is {}", n, result);
        System.out.println(n + "! = " + result);
    }

    private static void handleLogarithm(Scanner sc, MathLib lib) {
        System.out.print("Enter a number: ");
        double num = sc.nextDouble();
        logger.info("Handling ln() for input {}", num);
        double result = lib.ln(num);
        logger.info("Natural log result for {} is {}", num, result);
        System.out.println("ln(" + num + ") = " + result);
    }

    private static void handlePower(Scanner sc, MathLib lib) {
        System.out.print("Enter base: ");
        double base = sc.nextDouble();
        System.out.print("Enter exponent: ");
        double exp = sc.nextDouble();
        logger.info("Handling power function: base={}, exponent={}", base, exp);
        double result = lib.power(base, exp);
        logger.info("Power result for {}^{} is {}", base, exp, result);
        System.out.println(base + "^" + exp + " = " + result);
    }

}