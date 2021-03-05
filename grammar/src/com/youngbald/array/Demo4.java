package com.youngbald.array;

public class Demo4 {
    public static void main(String[] args) {
        //[3][2]
        int[][] a = {{1, 2}, {3, 4}, {5,6}};

        for (int i = 0; i < a.length; i++) {
            for (int i1 = 0; i1 < a[i].length; i1++) {
                System.out.print(a[i][i1]+" ");
            }
        }
    }


}
