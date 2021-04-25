/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/4/25
 * Time: 20:23
 * To change this template use File | Settings | File Templates.
 **/
public class BinarySearch {

    public static void main(String[] args) {
        int []nums = {2,45,98,130,162,197,201};
        boolean binary = findBinary(200, nums);
        System.out.println(binary);
    }

    static boolean  findBinary(int target,int []nums){
        // 初始left 和right
        int left = 0;
        int right = nums.length-1;


        while(left<=right) {
            int middle = (left + right)/2;
            if (nums[middle] < target) {
                // left 右移到middle上一位
                left = middle + 1;
            }
            if (nums[middle] > target) {
                right = middle - 1;
            }
            if (nums[middle] == target) {
                return true;
            }
        }
        return false;

    }

}
