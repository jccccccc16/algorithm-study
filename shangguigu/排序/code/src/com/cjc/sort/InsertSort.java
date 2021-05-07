package com.cjc.sort;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/4/27
 * Time: 20:46
 * To change this template use File | Settings | File Templates.
 * 插入排序
 **/
public class InsertSort {

    public static int[] sort(int []nums){
        // i为当前位置
        for(int i=1;i<nums.length;i++){
            // 控制当前位置与之前的有序数组比较
            int current=i;
            for(int j=i-1;j>=0;j--){

                // nums[i]为当前位置
                if(nums[j]>nums[current]){
                    // 如果小于就互换位置
                    int temp = nums[current];
                    nums[current] = nums[j];
                    nums[j] = temp;
                    current=j;
                }else{
                    // 如果大于，就是有序了，因为前面的数都是有序的
                    break;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] array = Utils.createArray(20);
        for (int s : array) {
            System.out.println(s);
        }
        System.out.println("++++++++++++++++++++++++");
        int[] sort = sort(array);
        for (int i : sort) {
            System.out.println(i);
        }
    }
}
