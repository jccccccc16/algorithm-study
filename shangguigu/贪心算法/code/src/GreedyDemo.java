import java.time.temporal.ValueRange;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/6/25
 * Time: 17:28
 * To change this template use File | Settings | File Templates.
 **/
public class GreedyDemo {

    static int value[] = new int[]{1,5,10,25,100};

    public static void main(String[] args) {
        int[] calculate = calculate(40, new int[value.length]);
        for (int i : calculate) {
            System.out.println(i);
        }
    }

    /**
     * 每一次都选择最大的
     * @param money
     * @return
     */
    public static int[] calculate(int money,int [] change){


        // change的index
        int index = 0;
        while(money!=0){
            for(int i=0;i< value.length;i++){
                if(money<value[i]) {
                    money = money - value[i-1];
                    change[index] = value[i-1];
                    break;
                }
            }
            index++;
        }
        return change;
    }
}
