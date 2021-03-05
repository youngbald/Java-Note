package com.youngbald.struct;

public class Demo9 {
    public static void main(String[] args) {
        //造个倒三角


        for (int i = 1; i <= 5; i++) {
            for(int j = 5;j>=i;j--){
                System.out.print(" ");
            }
            for(int j = 1; j<=i; j++){
                System.out.print("*");
            }
            for(int j = 1;j<i;j++){
                System.out.print("*");
            }

            System.out.println();
        }

    }


}
