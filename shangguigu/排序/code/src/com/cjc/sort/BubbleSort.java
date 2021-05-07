package com.cjc.sort;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/4/26
 * Time: 22:38
 * To change this template use File | Settings | File Templates.
 **/
public class BubbleSort {
    public static int[] sort(int []nums){
        for(int j=0;j<nums.length;j++){
            for(int i=0;i<nums.length-1-j;i++){
                if(nums[i]>nums[i+1]) {
                    int temp;
                    temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }
            }
        }

        return nums;
    }

    public static int[] sortOpimize(int []nums){
        boolean flag = false; // 表示为一趟比较下来，没有比较操作
        for(int j=0;j<nums.length;j++){
            for(int i=0;i<nums.length-1-j;i++){
                if(nums[i]>nums[i+1]) {
                    flag = true; // 有比较
                    int temp;
                    temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }
            }
            // 一趟比较过后
            // 如果没有比较操作
            if(!flag){
                // 认为该数组已经有序
                break;
            }else{
                // 重置flag
                flag =false;
            }
        }

        return nums;
    }

    public static void main(String[] args) {

        int []nums = {1,5,9,12,68,79,80};
        int[] sort = sort(nums);
        int[] sortOpimize = sortOpimize(nums);
        for (int num : nums) {
            System.out.println(num);
        }
        System.out.println("--------------------------");
        for (int i : sortOpimize) {
            System.out.println(i);
        }
    }
}
