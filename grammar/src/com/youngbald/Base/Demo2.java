package com.youngbald.Base;

public class Demo2 {


    //类百年来 static
    static double salary = 2500;

    //属性：变量
    //实例变量:从属于对象：通过这个类去使用他
    //不自动初始化，就会变成默认值 0 0.0
    //boolean = false
    //除了基本类型，其余的默认都是null
    String name;
    int age;

    //main
    public static void main(String[] args) {
        //局部变量：必须声明和初始化值
        int i = 10;

        //变量类型：变量名字 = new com.youngbald.Base.Demo2();
        Demo2 demo2 = new Demo2();
        System.out.println(demo2.age);
        System.out.println(demo2.name);


        System.out.println(salary);


        //类变量 static
    }

    //其他method
    public void add(){

    }
}
