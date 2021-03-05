package com.youngbald.oop.Demo4;

public class Person {
    {
//        2.初始值
        System.out.println("匿名代码块");
    }
    static{
//        1：只执行一次
        //静态代码块
        System.out.println("静态代码块");//最先运行
        //只执行一次
    }
//3
    public Person(){
        System.out.println("构造方法");
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
    }
}
