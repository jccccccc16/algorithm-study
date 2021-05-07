import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/5/7
 * Time: 10:56
 * To change this template use File | Settings | File Templates.
 **/
public class FibonaciiDP {

    private static Map<Integer,Integer> memoMap = new HashMap<>();

    public static void main(String[] args) {
        int fib = fib(10);
        int fibDP = fibDP(10);
        System.out.println(fib);
        System.out.println(fibDP);
    }
    public static int fib(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }

    public static int fibDP(int n){
        if(memoMap.get(n)!=null){
            return memoMap.get(n);
        }
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int fib = fib(n-1)+fib(n-2);
        memoMap.put(n,fib);
        return fib;
    }

}
