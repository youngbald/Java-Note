package com.youngbald.array;

public class Demo1 {

    //变量的类型 变量的名字 = 变量的值；
    //数组类型
    public static void main(String[] args) {
        int[] nums = new int[10];//这里面可以存放10个int类型的数字

        //给数组元素赋值
        for (int i = 0; i < nums.length; i++) {
            nums[i] =i+1;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
            sum+=nums[i];

        }
        System.out.println("sum is "+ sum);
    }
}
