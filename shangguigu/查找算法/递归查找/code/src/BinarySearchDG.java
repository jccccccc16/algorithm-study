/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/4/25
 * Time: 20:43
 * To change this template use File | Settings | File Templates.
 **/
public class BinarySearchDG {
    public static void main(String[] args) {
        int []nums = {2,45,98,130,162,197,201};
        boolean binary = findBinaryDG(201, nums);
        System.out.println(binary);
    }


    static boolean findBinaryDG(int target,int []nums){
        int left = 0;
        int right = nums.length -1;
        boolean b = find(target, nums, left, right);
        return b;
    }

    /**
     * left 和right 都是 源数组的下标
     * @param target
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private static boolean find(int target,int []nums,int left,int right){

        if(left>right){
            return false;
        }
        int middle = (left+right)/2;
        if(nums[middle] == target){
            return true;
        }else if(nums[middle]<target){
            left = middle+1;
            return find(target,nums,left,right);
        }else if(nums[middle]>target){
            right = middle -1;
            return find(target,nums,left,right);
        }
        return false;
    }
}
