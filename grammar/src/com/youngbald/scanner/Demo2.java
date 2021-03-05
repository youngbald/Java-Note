package com.youngbald.scanner;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        float f = 0.0f;
        System.out.println("enter en integer:");
        if(scanner.hasNextInt()){
            i = scanner.nextInt();
            System.out.println("整数数据"+i);
        }else{
            System.out.println("it is not an integer!");
        }

        System.out.println("please enter a float number");
        if(scanner.hasNextFloat()){
            f = scanner.nextFloat();
            System.out.println("浮点数据"+f);
        }else{
            System.out.println("not a float number!");
        }
    }
}
