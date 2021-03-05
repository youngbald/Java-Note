package com.youngbald.struct;

public class Demo8 {
    public static void main(String[] args) {
       //101-150 prime num
        int count=  0;
        outer:for (int i = 101; i < 150; i++) {
            for(int j = 2;j<i/2;j++){
                if(i%j==0){
                    continue outer;
                }
            }
            System.out.print(i+" ");
        }
    }
}
