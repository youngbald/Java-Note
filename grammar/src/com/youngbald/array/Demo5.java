package com.youngbald.array;


import java.util.Arrays;

public class Demo5 {
    public static void main(String[] args) {
        int [] a = {1,2,4,213,43,5,2312,2,4566};
        System.out.println(a);//[I@1b6d3586

        //print
        System.out.println(Arrays.toString(a));
        //排序
        Arrays.sort(a);
        //print
        System.out.println(Arrays.toString(a));

        //fill 填充
        Arrays.fill(a,2,4,0);
        System.out.println(Arrays.toString(a));
        Arrays.fill(a,0);
        System.out.println(Arrays.toString(a));
    }


}
