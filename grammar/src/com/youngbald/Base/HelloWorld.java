package com.youngbald.Base;

public class HelloWorld {
    public static void main(String[] args) {
       //操作比较大的数字，注意溢出问题
        //jdk7, 数字之间可以用下划线分割
        int money =10_0000_0000;
        int years =20;
        int total = money*years;//溢出了
        long total2 = money*years;//默认是int，转换之前已经存在问题了
        long total3 = years*(long)money;//先把一个数转换为long
        System.out.println(total);
        System.out.println(total2);
        System.out.println(total3);

    }
}
