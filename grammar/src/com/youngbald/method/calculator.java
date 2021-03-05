package com.youngbald.method;

import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your operation as +-*/");
        char a = scanner.next().charAt(0);
        double res = 0.0;

        System.out.println("enter numb1, quit with 'q'");

        while (scanner.hasNextDouble()) {
            double num1 = scanner.nextDouble();
            System.out.println("enter numb2");

            double num2 = scanner.nextDouble();

            switch (a) {
                case '+':
                    res = add(num1, num2);
                    break;
                case '-':
                    res = minus(num1, num2);
                    break;
                case '*':
                    res = times(num1, num2);
                    break;
                case '/':
                    res = over(num1, num2);
                    break;
                default:
                    res = 0;
                    System.out.println("operation is invalid!");
            }
            System.out.println("your result is: " + res);

        }
    }


    public static double add(double a, double b){
        return a+b;
    }
    public static double minus(double a, double b){
        return a-b;
    }
    public static double times(double a, double b){
        return a*b;
    }
    public static double over(double a, double b){
        return a/b;
    }


    }
