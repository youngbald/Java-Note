package com.youngbald.method;

public class Demo2 {
    public static void main(String[] args) {
        int a = max(100,100);
        double b  =max(10.2,130.2);
        System.out.println(a);
        System.out.println(b);

    }

    public static int max(int a, int b){
        if(a==b){
            System.out.println("they are equal");
            return 0; //中止方法
        }
       return  a>b? a:b;
    }
    public static double max(double a, double b){
        if(a==b){
            System.out.println("they are equal");
            return 0; //中止方法
        }
        return  a>b? a:b;
    }
    public static int add(int a , int b ,int c){
        return a+b+c;
    }

}
