package com.cjc.sort;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/4/27
 * Time: 16:53
 * To change this template use File | Settings | File Templates.
 **/
public class Utils {
    public static int[] createArray(int length){
        int[] ints = new Random().ints(0, length*10).distinct().limit(length).toArray();
        return ints;

    }

    public static void main(String[] args) {
        int[] array = createArray(10);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
