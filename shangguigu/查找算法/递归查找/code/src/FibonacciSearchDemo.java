import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/4/25
 * Time: 21:20
 * To change this template use File | Settings | File Templates.
 * 斐波那契查找法
 **/
public class FibonacciSearchDemo {
    public static void main(String[] args) {
        int []arr = {1,3,5,12,56,89,100,168,498};
        System.out.println("index = "+fibSearch(168,arr));
    }

    public static int[] fib(){
        int[] f = new int[20];
        f[0] = 1;
        f[1] = 1;
        for(int i=2;i<20;i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }

    /**
     *
     * @param target 需要查找的值
     * @param nums
     * @return 下标
     */
    public static int fibSearch(int target ,int[] nums){
        int low = 0;
        int high = nums.length-1;
        int k = 0; // 表示斐波那契分割数值的下标
        int middle = 0;
        int f[] = fib();
        // 由于我们将数组长度进行黄金分割，我们需要获取接近数组长度的斐波那契数

        while(high>f[k]-1){
            k++;
        }
        // f[k]-1可能大于数组长度;
        // 构造一个长度为f[k]-1的长度
        int[] temp = Arrays.copyOf(nums,f[k]);
        // 填充多出来的部分
        for(int i=high +1;i<temp.length;i++){
            temp[i]=nums[high]; // 保证数组升序
        }
        while(low<=high){
            middle = low+f[k-1]-1;
            if(target<temp[middle]){
                high = middle-1;
                // 左边为f[k-1]个元素
                // f[k] = f[k-1] + f[k-2]
                // 那么左边又可以拆分，f[k-1] = f[k-2] + f[k-3]
                k= k-1;
            }else if(target>temp[middle]){
                low = middle+1;
                // 那么右边有 f[k-2]个元素 f[k-3] + f[k-4]
                k = k-2;
            }else{
                if(middle<=high){
                    return middle;
                }else{
                    // 如果middle已经越界
                    return high;
                }
            }

        }
        return -1;
    }


}
