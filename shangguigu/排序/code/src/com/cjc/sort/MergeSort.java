package com.cjc.sort;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MergeSort {
    public static void main(String[] args) {
//        int []aa = {1,2,3,4};
//        int []bb = {5,6,7};
//        int[] add = add(aa, bb);
//        for (int i : add) {
//            System.out.println(i);
//        }
        int[] nums = Utils.createArray(10000);
//        int []nums = {45,78,14,6,287,94,23,46,45,79};
        long startTime =  System.currentTimeMillis();
        int[] sort = sort(nums);
        long endTime =  System.currentTimeMillis();
        for (int i : sort) {
            System.out.println(i);
        }
        long usedTime = (endTime-startTime)/100;
        System.out.println(usedTime);

    }

    public static int[] sort(int[] nums){

        if(nums.length<2){
            return nums;
        }
        int middle = (int)(nums.length/2);
        CutMapper cutMapper =cut(nums,middle);
        int[] leftNums = cutMapper.getLeft();
        int[] rightNums = cutMapper.getRight();
        int[] leftResult = sort(leftNums);
        int[] rightResult = sort(rightNums);
        return merge(leftResult,rightResult);
    }

    public static int[] merge(int[] left,int[] right) {
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        // 合并为一个数组
        int[] totalNums = add(left, right);
        // 由于左右是有序的
//        for (int ri = left.length; ri < totalNums.length; ri++) {
//            // 与前面的left对比，如果小于则交换位置
//            for (int li = left.length - 1; li >=0; li--) {
//                if (totalNums[li] > totalNums[ri]) {
//                    int temp = totalNums[li];
//                    totalNums[li] = totalNums[ri];
//                    totalNums[ri] = temp;
//                    break;
//                }
//            }
//
//
//        }
        for(int i=1;i<totalNums.length;i++){
            int current = i;
            for(int j=i-1;j>=0;j--){
                if(totalNums[j]>totalNums[current]){
                    int temp=totalNums[j];
                    totalNums[j]=totalNums[current];
                    totalNums[current]=temp;
                    current=j;
                }else{
                    break;
                }
            }
        }
        return totalNums;
    }

    public static int[] add(int[] left,int[] right){
        int[] total = new int[left.length + right.length];
        System.arraycopy(left,0,total,0,left.length);
        System.arraycopy(right,0,total,left.length,right.length);
        return total;
    }

    public static CutMapper cut(int []nums,int middle){
        int[] left = Arrays.stream(nums).limit(middle).toArray();
        int[] right = Arrays.stream(nums).skip(middle).toArray();
        return new CutMapper(left,right);
    }

    static class CutMapper{
        private int[] left;
        private int[] right;

        public CutMapper(int[] left, int[] right) {
            this.left = left;
            this.right = right;
        }

        public int[] getLeft() {
            return left;
        }

        public void setLeft(int[] left) {
            this.left = left;
        }

        public int[] getRight() {
            return right;
        }

        public void setRight(int[] right) {
            this.right = right;
        }
    }
}
