import com.sun.deploy.ref.DeployJRE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/6/27
 * Time: 23:04
 * To change this template use File | Settings | File Templates.
 * 最小路径，尝试自己写
 **/
public class DijkstraAttempt {

    private int[][] matrix;
    private String[] nodes;
    public static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {
        DijkstraAttempt dijkstraAttempt = new DijkstraAttempt();
        int[][] primMap = new int[][]{
                {0,5,7,MAX,MAX,MAX,2},
                {5,0,MAX,9,MAX,MAX,3},
                {7,MAX,0,MAX,8,MAX,MAX},
                {MAX,9,MAX,0,MAX,4,MAX},
                {MAX,MAX,8,MAX,0,5,4},
                {MAX,MAX,MAX,4,5,0,6},
                {2,3,MAX,MAX,4,6,0},
        };
        List<String> nodeNameList =new ArrayList<String>(){{
            add("A");
            add("B");
            add("C");
            add("D");
            add("E");
            add("F");
            add("G");
        }};
        dijkstraAttempt.djDropTheBeat(new Graph(nodeNameList,primMap),0,4);
    }

    public void djDropTheBeat(Graph graph,int startPoint,int endPoint){



        int nodeSize = graph.getNodeSize();
        nodes = new String[nodeSize];

        this.matrix = new int[nodeSize][nodeSize];
        int[][] matrix = graph.getMatrix();
        for(int i=0;i<nodeSize;i++){
            for(int j=0;j<nodeSize;j++){
                this.matrix[i][j] = matrix[i][j];
            }
        }
        List<String> nodeList = graph.getNodeList();

        for(int i=0;i<nodeSize;i++){
            this.nodes[i] = nodeList.get(i);
        }



        calculate(startPoint,endPoint);
        calculate0(startPoint,endPoint);
    }

    // 使用了贪心算法
    private void calculate0(int startPoint,int endPoint){
        // 记录起点到每个终点的距离
        int[] minDistance = new int[nodes.length];
        // 初始化
        for(int i=0;i<nodes.length;i++){
            minDistance[i] = Integer.MAX_VALUE;
        }
        // 存储最短路径的边
        int [] minPath = new int[nodes.length];
        int minPathIndex = 0;
        for(int i=0;i<nodes.length;i++){
            minPath[i] = -1;
        }
        minPath[minPathIndex++] = startPoint;
        boolean[] isVisit = new boolean[nodes.length];



        minDistance[startPoint] = this.matrix[startPoint][startPoint];

        Queue queue = new LinkedList<Integer>();
        queue.offer(startPoint);
        while(!queue.isEmpty()){
            int pointIndex = (int) queue.poll();
            if(pointIndex==endPoint){
                break;
            }
            // 如果已经访问过
            if(isVisit[pointIndex]){
                continue;
            }
            // 设置为以访问
            isVisit[pointIndex] = true;
            for(int i=0;i<nodes.length;i++){
                // 获取邻接节点
                int distance=minDistance[i];
                int weight = this.matrix[pointIndex][i];
                if(weight!=MAX){
                    // 0如果该邻接节点i和该节点的距离加上pointIndex的最短距离小于i节点的最小距离，那么更新i的最短距离
                    if(this.matrix[pointIndex][i]+minDistance[pointIndex]<distance){
                        minDistance[i] = this.matrix[pointIndex][i]+minDistance[pointIndex];
                    }
                }
            }

            // 贪心策略，取最小的作为下一个节点
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for(int i=0;i<minDistance.length;i++){
                if(!isVisit[i]){
                    if(minDistance[i]<min){
                        minIndex = i;
                    }
                }
            }
            minPath[minPathIndex++] = minIndex;
            // 作为下一个
            queue.offer(minIndex);
        }

        System.out.println(minDistance[endPoint]);
        for (int i : minPath) {
            if(i==-1){
                continue;
            }
            System.out.print(nodes[i]+"->");
        }

    }

    // 算出全部节点的最短路径
    private void calculate(int startPoint,int endPoint){
        // 记录起点到每个终点的距离
        int[] minDistance = new int[nodes.length];
        // 初始化
        for(int i=0;i<nodes.length;i++){
            minDistance[i] = Integer.MAX_VALUE;
        }
        // 存储最短路径的边
        ArrayList<String> nodesResult = new ArrayList<>();

        boolean[] isVisit = new boolean[nodes.length];

        nodesResult.add(getPoint(startPoint));
        minDistance[startPoint] = this.matrix[startPoint][startPoint];

        Queue queue = new LinkedList<Integer>();
        queue.offer(startPoint);
        while(!queue.isEmpty()){
            int pointIndex = (int) queue.poll();
            // 如果已经访问过
            if(isVisit[pointIndex]){
                continue;
            }
            // 设置为以访问
            isVisit[pointIndex] = true;
            for(int i=0;i<nodes.length;i++){
                if(!isVisit[i]){
                    queue.offer(i);
                }
                // 获取邻接节点
                int distance=minDistance[i];
                int weight = this.matrix[pointIndex][i];
                if(weight!=MAX){
                    // 0如果该邻接节点i和该节点的距离加上pointIndex的最短距离小于i节点的最小距离，那么更新i的最短距离
                    if(this.matrix[pointIndex][i]+minDistance[pointIndex]<distance){
                        minDistance[i] = this.matrix[pointIndex][i]+minDistance[pointIndex];
                    }
                }
            }
        }

        for (int i : minDistance) {
            System.out.print(" "+i);
        }

//        // 得到到达各个节点的最小路径
//        // 根据minDistance表查找到达endPoint的最小路径
//        boolean[] isVisit2 = new boolean[nodes.length];
//        isVisit2[endPoint] = true;
//        int point = endPoint;
//        int currentMinDistance = Integer.MAX_VALUE;
//        int currentMinDistancePoint = endPoint;
//        while(point!=startPoint){
//            for(int i=0;i<nodes.length;i++){
//                if((!isVisit2[point])&&(matrix[point][i]!=MAX)){
//                    if(matrix[point][i]<currentMinDistance){
//                        // 保存最小距离的节点
//                        currentMinDistancePoint = i;
//                    }
//                }
//            }
//            point = currentMinDistancePoint;
//            System.out.println(point);
//        }


    }

    public String getPoint(int index){
        return nodes[index];
    }

}
