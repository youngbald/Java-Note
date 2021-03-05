package com.youngbald.array;

public class Demo2 {
    public static void main(String[] args) {
        //静态初始化,创建加赋值
        int [] a  ={1,2,3,4,5,6,7};
        System.out.println(a[0]);
        //引用类型
        Demo2[] demos = {new Demo2(),new Demo2()};

        //动态初始化:包含默认初始化 都是0
        int[] b = new int[10];
        b[0] =10;
        System.out.println(b[0]);
    }
}
