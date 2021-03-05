package com.youngbald.scanner;

import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        double sum = 0;
        System.out.println("please enter a number");
        while(scanner.hasNextDouble()){
            System.out.println("please enter a number ");
            count++;
            sum = sum+ scanner.nextDouble();

        }
        System.out.println("the average of your inputs is :");
        System.out.println(sum/count);

        scanner.close();
    }
}
