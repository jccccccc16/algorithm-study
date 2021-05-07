package com.cjc.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/4/28
 * Time: 16:55
 * To change this template use File | Settings | File Templates.
 **/
public class QuickSort {

    public static int [] sort(int []nums){

        if(nums.length==1){
            return nums;
        }
        if(nums.length==0){
            return null;
        }

        // 获取基线
        int middle = (int)(nums.length/2);
        // 基线
        int middleNum = nums[middle];
        // 比基线小的数放在left中，right同理
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        // 遍历原数组
        // 遍历左边
        // 比基线小的不动，比基线大的放在右边
        for(int i=0;i<middle;i++){
            if(nums[i]>middleNum){
                rightList.add(nums[i]);
            }else{
                leftList.add(nums[i]);
            }
        }
        for(int j=middle+1;j<nums.length;j++){
            if(nums[j]<middleNum){
                leftList.add(nums[j]);
            }else{
                rightList.add(nums[j]);
            }
        }

        int[] leftIns = leftList.stream().mapToInt(Integer::intValue).toArray();
        int[] rightIns = rightList.stream().mapToInt(Integer::intValue).toArray();
        // 递归左边
        int[] leftResult = sort(leftIns);
        int[] rightResult = sort(rightIns);

        return merge(leftResult,middleNum,rightResult);

    }

    public static  int[] merge(int []left,int middleNum,int []right){
        int result[]=null;
        if(left==null){
            result= new int[right.length+1];
            result[0]=middleNum;
            for(int i=0;i<right.length;i++){
                result[i+1]=right[i];
            }
            return result;
        }else if(right==null){
            result= new int[left.length+1];
            for(int i=0;i<left.length;i++){
                result[i]=left[i];
            }
            result[left.length]=middleNum;
            return result;
        }
        result=new int[left.length+right.length+1];
        int i;
        for(i=0;i<left.length;i++) {
            result[i] = left[i];
        }
        result[i]=middleNum;
        for(int j=1;j<right.length+1;j++){
            result[i+j] = right[j-1];
        }
        return result;


    }


    public static void main(String[] args) {
//        int right[]={6,7,8,9};
//        int left[] = {1,2,3,4};
//        int[] merge = merge(left, 5, right);
//        for (int i : merge) {
//            System.out.println(i);
//        }
        int nums[] = {-9,78,0,23,-567,70};
        int[] sort = sort(nums);
        for (int i : sort) {
            System.out.println(i);
        }
    }
}
