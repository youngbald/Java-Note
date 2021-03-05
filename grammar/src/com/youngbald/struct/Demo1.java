package com.youngbald.struct;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
        String s = scanner.nextLine();

        //equals 用来判断字符串是否相等
        if(s.equals("Hello")){
            System.out.println(s);
        }else{
            System.out.println("World");
        }

        scanner.close();
    }
}
