package com.youngbald.array;

public class Demo3 {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5};
        int sum = 0;

        //print sum of the array
        //没有下标
        for(int i:nums){
            sum+=i;
            System.out.println(i);
        }
        System.out.println(sum);
        //print max num in array
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(max<nums[i]){
                max = nums[i];
            }
        }
        System.out.println(max);

        printArr(nums);

        int[] reverse = reverse(nums);
        printArr(reverse);

    }


    public static void printArr(int[] a){
        for (int i : a) {
            System.out.print(i+ " ");

        }
        System.out.println();

    }
    public static int[] reverse(int[] a){
        int n = a.length;
        int[]res = new int[n];
        for(int i = 0, j = res.length-1;i<n;i++,j--){
            res[j] = a[i];

        }
        return res;
    }
}
