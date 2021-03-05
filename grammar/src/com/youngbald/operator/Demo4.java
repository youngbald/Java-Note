package com.youngbald.operator;

public class Demo4 {
    public static void main(String[] args) {
        //++ -- 自增自减，一元运算符
        int a  =3;
        int b = a++;//after this line of code, assign b to 3 then a = a+1
        //a = a+1;
        System.out.println(a);
        //a+ a= a+1;
        int c = ++a;//before this line of code, a = a+1,
        // then assign the value to c
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);


        //幂运算 2^3 很多其他运算使用工具来操作
       double pow = Math.pow(3,2);
        System.out.println(pow);
    }
}
