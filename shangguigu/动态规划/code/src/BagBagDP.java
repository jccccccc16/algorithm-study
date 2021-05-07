/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/5/7
 * Time: 11:15
 * To change this template use File | Settings | File Templates.
 **/
public class BagBagDP {

    public static void main(String[] args) {
        BagBagDP bagBagDP = new BagBagDP();
        int calculate = bagBagDP.calculate();
        System.out.println(calculate);
    }
    // 吉他，音响，电脑，篮球
    // 价值
    int[] val = new int[]{1500,3000,2000,1000};
    // 重量
    int[] weight = new int[]{2,4,3,1};
    // 背包容量4
    static final int CAP = 5;
    int n = val.length;

    int v[][] = new int[n][CAP+1];
    public  int calculate(){

        for(int i=1;i<n;i++){
            for(int j=1;j<=CAP;j++){
                // 能不能放进来
                if(weight[i]<=j){
                    // 如果能放进来
                    int total = val[i]+v[i-1][j-weight[i]];
                    if(total>v[i-1][j]){
                        v[i][j] = total;
                    }else{
                        v[i][j] = v[i-1][j];
                    }
                }else{ // 放不进来，填上一个单元
                    v[i][j] = v[i-1][j];
                }
            }
        }


        return v[n-1][CAP];

    }
}
