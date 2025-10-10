package com.project.demo.app;

import com.project.demo.Math.*;
import java.util.Scanner;
public class Main {
    // Hi
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MathLib calculator = new MathLib();
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Select an option: ");

            int option = input.nextInt();

            try {
                switch (option) {
                    case 1 -> handleSquareRoot(input, calculator);
                    case 2 -> handleFactorial(input, calculator);
                    case 3 -> handleLogarithm(input, calculator);
                    case 4 -> handlePower(input, calculator);
                    case 5 -> {
                        System.out.println("Thank you for using the calculator. Goodbye!");
                        running = false;
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }

            System.out.println();
        }

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
        System.out.println("√" + num + " = " + lib.sqrt(num));
    }

    private static void handleFactorial(Scanner sc, MathLib lib) {
        System.out.print("Enter an integer: ");
        int n = sc.nextInt();
        System.out.println(n + "! = " + lib.factorial(n));
    }

    private static void handleLogarithm(Scanner sc, MathLib lib) {
        System.out.print("Enter a number: ");
        double num = sc.nextDouble();
        System.out.println("ln(" + num + ") = " + lib.ln(num));
    }

    private static void handlePower(Scanner sc, MathLib lib) {
        System.out.print("Enter base: ");
        double base = sc.nextDouble();
        System.out.print("Enter exponent: ");
        double exp = sc.nextDouble();
        System.out.println(base + "^" + exp + " = " + lib.power(base, exp));
    }

}