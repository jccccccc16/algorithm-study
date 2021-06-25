package com.cjc;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/4/23
 * Time: 10:42
 * To change this template use File | Settings | File Templates.
 **/
public class AlgorithmDemo {
    public static void main(String[] args) {
        int []nums = {1,5,48,97,456,12,6,4,51,32,45};
        int targetNum = 12;
        Integer num = Utils.findNum(nums, targetNum);
        System.out.println(num);

    }
}
