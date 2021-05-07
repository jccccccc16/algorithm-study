package com.cjc.sort;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/4/27
 * Time: 16:43
 * To change this template use File | Settings | File Templates.
 * 选择排序
 **/
public class ChooseSort {

    public static int[] sort(int []nums){

        for(int i=0;i<nums.length;i++){
            // 当前位置往后比较
            int min=0;
            min = i;
            for(int j=i;j<nums.length-1;j++){
                if(nums[min]>nums[j+1]){
                    min = j+1;
                }
            }
            // 最小值与当前位置交换
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }

        return nums;
    }

    public static void main(String[] args) {
        int []nums = Utils.createArray(40);
        for (int num : nums) {
            System.out.println(num);
        }
        System.out.println("---------------------------");
        int[] sort = sort(nums);
        for (int i : sort) {
            System.out.println(i);
        }
    }
}
