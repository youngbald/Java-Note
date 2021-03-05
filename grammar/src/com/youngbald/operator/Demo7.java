package com.youngbald.operator;

public class Demo7 {
    public static void main(String[] args) {
        int a  = 10;
        int b = 20;
        a+=b; //a = a+b
        a-=b; //a = a-b
        System.out.println(a);
        //字符串连接符 + String
        System.out.println(a+b);
        //结果会变成String
        System.out.println(""+a+b);
        //加放在字符串前面不会被影响
        System.out.println(a+b +"");
    }
}
