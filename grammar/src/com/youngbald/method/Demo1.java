package com.youngbald.method;

public class Demo1 {
    public static void main(String[] args) {
        //实际调用传递给他的参数 叫做实际参数
        int a  = add(1,2);
        System.out.println(a);
        test(10);
    }

    //加法
    //加入static 变成类变量
    //形式参数 用来定义作用
    public static int add ( int a, int b){
        return a+b;
    }

    public static void test(int a){
        for (int i = 0; i < a; i++) {
            System.out.println(i);
        }

    }
}
