import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/6/26
 * Time: 14:23
 * To change this template use File | Settings | File Templates.
 * 最小生成树
 **/
public class PrimDemo {

    // 使用二维数组存储图
    static int[][] primMap = new int[][]{
            {0,5,7,0,0,0,2},
            {5,0,0,9,0,0,3},
            {7,0,0,0,8,0,0},
            {0,9,0,0,0,4,0},
            {0,0,8,0,0,5,4},
            {0,0,0,4,5,0,6},
            {2,3,0,0,4,6,0},
    };

    static List<String> nodeNameList =new ArrayList<String>(){{
        add("A");
        add("B");
        add("C");
        add("D");
        add("E");
        add("F");
        add("G");
    }};



    public static void main(String[] args) {
        List<String> calculate = calculate();

    }

    public static List<String> calculate(){

        List<String> result = new ArrayList<>();
        // 判断是否已经访问
        boolean[] isVisit = new boolean[nodeNameList.size()];

        // 初始化result，添加A作为初始节点
        result.add(nodeNameList.get(0));
        System.out.print(nodeNameList.get(0));
        isVisit[0] = true;
        int total = 0;
        // 遍历结合中的节点的临界节点，如果result中包含所有节点为止
        while (result.size()!=nodeNameList.size()){
            int minWeight =  Integer.MAX_VALUE;
            // 权最小的顶点
            String minNode = "";
            // 找出没有访问过的（也就是没有放入到result中的），且权最小的节点
            for (String node : result) {

                // 在二维矩阵中找到对于的行
                int index = nodeNameList.indexOf(node);
                for(int i=0;i<nodeNameList.size();i++){
                    if(!isVisit[i]){
                        int weight = primMap[index][i];
                        if(weight!=0&&weight<minWeight){
                            minWeight = weight;
                            minNode = nodeNameList.get(i);
                        }
                    }
                }
            }
            total = total+minWeight;
            // 得到最小的顶点,设置为以访问
            isVisit[nodeNameList.indexOf(minNode)] = true;
            System.out.print("-> "+minNode);
            // 放入到result中，设置为以访问
            result.add(minNode);
        }
        System.out.println("total: "+total);
        return result;

    }
}
