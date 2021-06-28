### 胡图图

#### 为什么要有图？

可以表示多对多

有权，边带权值

有向

#### 图的表示（存储）：

- 二维数组表示（邻接矩阵）；

  二维数组如何表示，看老师笔记

  0为不邻接

- 链表表示（邻接表）;

  数组加链表，节点为在图中邻接的节点

  ![在这里插入图片描述](https://img-blog.csdnimg.cn/20210429200129183.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDc3MTU4Mg==,size_16,color_FFFFFF,t_70)

  

#### quick Start

```java
public class Graph {
    // 存储顶点集合
    private ArrayList<String> vertexList;
    private int[][] edges; // 存储边
    private int numOfEdges; // 边的数目
}
// 插入节点数据
 public void insertVertex(String vertex){
        vertexList.add(vertex);
 }
// 插入边
public void insertEdge(int v1,int v2,int weight){
        // 由于是无向图，那么两边的权值相等
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        // 变数加一
        numOfEdges++;
}
public static void main(String[] args) {
        int n=5;
        String vertexs[] = {"A","B","C","D","E"};
        Graph graph = new Graph(n);
        for (String vertex : vertexs) {
            graph.insertVertex(vertex);
        }
        // 添加边
        // A-B,A-C,B-C,B-D,B-E
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        graph.show();
    }
```

#### 遍历

##### 深度优先

- 输出，并且isVisist设置为true

- 遍历邻接节点，如果邻接节点没有被访问，那么递归遍历该节点的邻接节点

- 如果节点没有未访问的邻接节点，那么回退（看代码）

  ![在这里插入图片描述](https://img-blog.csdnimg.cn/2021062516261163.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDc3MTU4Mg==,size_16,color_FFFFFF,t_70)

  ![在这里插入图片描述](https://img-blog.csdnimg.cn/20210625162658163.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDc3MTU4Mg==,size_16,color_FFFFFF,t_70)

  - 没有邻接节点了！，结束！（基线条件）

```java
/**
     *
     * @param isVisited 用于判断该节点是否已被访问
     * @param i 从那个节点开始
     */
    public  void DFS(boolean[] isVisited,int i){
        System.out.println(this.getValueByIndex(i));
        // 设置为已被遍历
        isVisited[i] = true;
        boolean flag = true;
      
        for(int index=0;index<getNumOfVertexSize();index++){
            if(!isVisited[index]){
                flag=false;
            }
        }
        // 基线条件，当isVisit全部为true时，该节点的所有邻接节点都被访问
        if(flag){
            return;
        }
        // 遍历邻接节点
        // 获取邻接节点
        for(int j=0;j<getNumOfVertexSize();j++){
            if(edges[i][j]!=0&&!isVisited[j]){
                DFS(isVisited, j);
            }
        }
    }
```











##### 广度优先

- 先访问自己
- 在访问邻接节点，并放入队列
- 取出第一个，递归

