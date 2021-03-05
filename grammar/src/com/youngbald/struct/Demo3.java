package com.youngbald.struct;

import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        char grade  = 'A';
        switch (grade){
            case 'A':
                System.out.println("优秀");
                break;
                //一定需要break不然会继续运行下面的代码
            case 'B':
                System.out.println("良好");
                break;
            default:
                System.out.println("菜鸡！");
                //default 似乎不需要break

        }
    }
}
