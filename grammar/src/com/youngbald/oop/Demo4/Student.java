package com.youngbald.oop.Demo4;

public class Student  {

    private static int age;//静态
    private double score;//非静态变量

    //非静态可以直接调用静态方法
    //静态方法基本就是在当前class里可以被直接调用的一个值，不需要通过类来执行

    public void run(){
        go();
    }
    public static void go(){

    }

    public static void main(String[] args) {
        new Student().run();
        go();


    }
}
