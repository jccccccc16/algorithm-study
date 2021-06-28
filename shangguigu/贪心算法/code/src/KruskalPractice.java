/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/6/27
 * Time: 13:43
 * To change this template use File | Settings | File Templates.
 * 经过学习后自己写一些。
 **/
public class KruskalPractice {

    private int[][] matrix;
    private char[] nodeName;
    private int[] ends;
    public static void main(String[] args) {

    }


    public KruskalPractice(char[] nodeName,int[][] matrix){



        int length = nodeName.length;
        this.matrix = new int[length][length];
        // 存放每一个顶点对应的终点
        this.ends= new int[length];
        // 存放最小森林的边
        Edge[] result = new Edge[nodeName.length-1];
        // 复制数据到matrix
        int edgesNum = 0;
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                this.matrix[i][j] = matrix[i][j];
                edgesNum++;
            }
        }
        edgesNum = edgesNum/2;
        // nodename
        for(int i=0;i<length;i++){
            this.nodeName[i] = nodeName[i];
        }
        // 封装为Edge
        // 复制右上三角数据到matrix
        Edge[] edges = new Edge[edgesNum];
        int index=0;
        for(int i=0;i<length;i++){
            for(int j=i;j<length;j++){
                Edge edge = new Edge(this.matrix[i][j], i, j);
                edges[index] = edge;
                index++;
            }
        }
        // 根据权值排序
        sortEdge(edges);

        // 选择边
        for(int i=0;i<edgesNum;i++){
            // 取出边
            int node1 = edges[i].start;
            int node2 = edges[i].getEnd();
            // 获取两个顶点的终点
            int end1 = getEndPoint(node1);
            int end2 = getEndPoint(node2);
            // 是否成环c

        }


    }
    public int getEndPoint(int nodeIndex){

        while(this.ends[nodeIndex]!=0){
            nodeIndex = ends[nodeIndex];
        }
        return nodeIndex;

    }

    // 根据权值由小到大排序
    private void sortEdge(Edge[] edges) {
        // 插入排序
        for(int i=1;i<edges.length;i++){
            for(int j=i;j>0;j--){
                if(edges[j].getWeight()<edges[j-1].getWeight()){
                    Edge temp = edges[j];
                    edges[j] = edges[j-1];
                    edges[j-1] = temp;
                }
            }
        }


    }

    class Edge{
        private int weight;
        private int start;
        private int end;

        public Edge(int weight, int start, int end) {
            this.weight = weight;
            this.start = start;
            this.end = end;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }



}


