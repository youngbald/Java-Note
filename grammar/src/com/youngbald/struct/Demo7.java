package com.youngbald.struct;

public class Demo7 {
    public static void main(String[] args) {
        int [] num = {10,20,30,40,50};//定义一个数组
        for(int x:num){
            System.out.println(x);
        }

        //equavelent to
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
        }
    }


}
