package com.youngbald.operator;

public class Demo5 {
    public static void main(String[] args) {
        //逻辑运算符
        //与或非
        boolean a  = true;
        boolean b =false;
        System.out.println("a&&b:" +(a&&b));
        System.out.println("a||b:"+(a||b));
        System.out.println("!(a&&b):"+!(a&&b));

        //短路运算
        //错了只会运行前半部分 &&后面不运行
        int c =5;
        boolean d = (c<4)&&(c++<4);
        System.out.println(d);
        System.out.println(c);
    }
}
