package com.youngbald.operator;

public class Demo6 {
    public static void main(String[] args) {
        /*
        A = 0011 1100
        B = 0000 1111

        A&B = 0000 1100
        A|B = 0011 1101
        A^B =0011 0001   抑或
        ~B = 1111 0000 取反

        位运算效率极高

        2*8 = 16  2*2*2*2
        左移 <<*2
        >>右移 /

        0000 0000       0
        0000 0001       1
        0000 0010       2
        0000 0011       3

         */
        System.out.println(2<<3);
    }
}
