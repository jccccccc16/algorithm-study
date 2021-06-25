package com.cjc;

import sun.font.SunLayoutEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/4/23
 * Time: 10:42
 * To change this template use File | Settings | File Templates.
 **/
public class Utils {
    public static  Integer findNum(int[] nums,int target_num) {
        return find(nums,target_num,nums.length,true);

    }

    /**
     * @param nums
     * @param target_num
     * @param last_middle_index 上一次递归的中位索引，初始值为总长
     * @param isRight
     * @return
     */
    private static Integer find(int [] nums,int target_num,int last_middle_index,boolean isRight){

        // 该队列的middle
        int middle = getMiddle(nums);


        // 该队列的middle_index
        int middle_index = last_middle_index - middle;



        // 判断数组是否只有一个数
        if(nums.length == 1){
            // 判断是否为目标数
            // 是，那么返回下表；否，则返回null
            return nums[0]==target_num?(isRight?middle_index:middle_index-1):null;
        }
        // 判断nums是否为空
        if(nums.length == 0){
            return null;
        }
        // 判断中位是否为目标值
        if(nums[middle]==target_num){
            return middle_index;
        }

        int []left = cut(false,nums);
        int []right = cut(true,nums);
        Integer leftResult = find(left,target_num,middle_index,false);
        Integer rightResult = find(right,target_num,middle_index,true);
        // leftResult 和rightResult 又一边不为空那么就返回，如果返回null，那么就是找不到该目标数
        return leftResult!=null?leftResult:(rightResult!=null?rightResult:null);
    }

    private static int [] cut(boolean isRight,int []nums){
        IntStream stream = Arrays.stream(nums);
        int [] result=null;
        int middle = Integer.valueOf(nums.length / 2);
        if(isRight){
            result = stream.skip(middle).toArray();
        }else{
            result = stream.limit(middle).toArray();
        }
        return result;
    }

    private static int getMiddle(int []nums){
        Integer middle = Integer.valueOf(nums.length / 2);
        return middle==0?1:middle;
    }

}
