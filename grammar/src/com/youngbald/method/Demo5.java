package com.youngbald.method;

public class Demo5 {
    public static void main(String[] args) {
        int a = f(5);
        System.out.println(a);
    }

    public static int f (int a){
        if(a==1) return 1;
        else{
            return a*f(a-1);
        }


    }
}
