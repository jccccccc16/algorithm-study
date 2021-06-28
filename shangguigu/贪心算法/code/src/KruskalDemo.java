import java.util.*;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/6/26
 * Time: 21:32
 * To change this template use File | Settings | File Templates.
 * 尝试使用使用取并集的方法判断闭环，在存储边的集合中，判断一条边的引入是否会导致回路，
 * 那么只需要判断引入的边的两个顶点是否都存在与集合中，如有都已经存在那么就判断为回路
 **/
public class KruskalDemo {

    // 表示不可联通


    public static void main(String[] args) {
        int[][] primMap = new int[][]{
                {0,5,7,0,0,0,2},
                {5,0,0,9,0,0,3},
                {7,0,0,0,8,0,0},
                {0,9,0,0,0,4,0},
                {0,0,8,0,0,5,4},
                {0,0,0,4,5,0,6},
                {2,3,0,0,4,6,0},
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
        KruskalDemo kruskalDemo = new KruskalDemo();
        Graph graph = new Graph(nodeNameList, primMap);
        kruskalDemo.calculate(graph);

    }

    public void calculate(Graph graph){

        List<Edge> result = new ArrayList<Edge>();

        List<String> nodeList = graph.getNodeList();
        // 存放节点用于判断是否形成回路
        Set<String> selectedNode = new HashSet<>();
        // 根据权值由小到大排列
        int[][] matrix = graph.getMatrix();
        // 存放边
        List<Edge> edgesList = new ArrayList<Edge>();

        // 封装为Edge
        for(int i=0;i<graph.getNodeSize();i++){
            for (int j=0;j<graph.getNodeSize();j++){
                Edge edge = new Edge(nodeList.get(i), nodeList.get(j), matrix[i][j]);
                edgesList.add(edge);
            }
        }
        Edge[] edges = edgesList.stream().toArray(Edge[]::new);
        // 排序边
        sortEdge(edges);

        int totalWeight = 0;

        for (Edge edge : edges) {
            // 判断是否与集合中的顶点形成回路
            List<String> nodes = edge.getNodes();
            // 如果不同时包含这两个顶点，那么就判断为没有回路
            if(!(selectedNode.containsAll(nodes))&&edge.getWeight()!=0){
                selectedNode.addAll(nodes);
                result.add(edge);
                totalWeight = totalWeight + edge.getWeight();
            }
            if(result.size()==(graph.getNodeSize()-1)){
                break;
            }

        }
        System.out.println(totalWeight);
        for (Edge edge : result) {
            System.out.println(edge.toString());
        }








    }

    public void sortEdge(Edge[] edges){
        for(int i=1;i<edges.length;i++){
            for(int j=i;j>0;j--){
                // 如果后一个比前一个权值小，那么换位
                if(edges[j].getWeight()<edges[j-1].getWeight()){
                    Edge temp  = edges[j];
                    edges[j] = edges[j-1];
                    edges[j-1] = temp;
                }
            }
        }
    }





}

class Edge{
    private String node1;
    private String node2;
    private int weight;
    private List<String> nodes;

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }

    public Edge(String node1, String node2, int weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
        nodes = new ArrayList<String>();
        nodes.add(node1);
        nodes.add(node2);
    }

    public String getNode1() {
        return nodes.get(0);
    }

    public void setNode1(String node1) {
        this.node1 = node1;
    }

    public String getNode2() {
        return nodes.get(1);
    }

    public void setNode2(String node2) {
        this.node2 = node2;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "node1='" + node1 + '\'' +
                ", node2='" + node2 + '\'' +
                ", weight=" + weight +
                ", nodes=" + nodes +
                '}';
    }
}



class Graph{
    // 存放图
    private int[][] matrix;
    // 存放节点
    private List<String> nodeList;
    // 边数
    private int edgeNum;




    public Graph(List<String> nodeList,int[][] matrix){
        // 初始化节点
        this.nodeList = new ArrayList<String>();
        this.nodeList.addAll(nodeList);
        int nodeNum = nodeList.size();
        // 初始化matrix
        this.matrix = new int[nodeNum][nodeNum];
        // 初始化边数
        int edgeNum = 0;
        // 将matrix复制到对象的matrix中
        for(int i=0;i<nodeNum;i++){
            for(int j=0;j<nodeNum;j++){
                this.matrix[i][j] = matrix[i][j];
                if(matrix[i][j]!=0){
                    edgeNum++;
                }
            }
        }
        this.edgeNum = edgeNum/2;

    }

    public int getNodeSize(){
        return nodeList.size();
    }


    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public List<String> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<String> nodeList) {
        this.nodeList = nodeList;
    }

    public int getEdgeNum() {
        return edgeNum;
    }

    public void setEdgeNum(int edgeNum) {
        this.edgeNum = edgeNum;
    }
}
