package com.cjc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/4/29
 * Time: 20:09
 * To change this template use File | Settings | File Templates.
 * 邻接矩阵存储图
 **/
public class Graph {
    // 存储顶点集合
    private ArrayList<String> vertexList;
    private int[][] edges; // 存储边
    private int numOfEdges; // 边的数目

    // 初始化图
    public Graph(int n){
        edges = new int[n][n];
        vertexList=new ArrayList<String>(n);
        numOfEdges=0;
    }
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    public int getNumOfEdges(){
        return numOfEdges;
    }
    public int getNumOfVertexSize(){
        return vertexList.size();
    }

    /**
     * 返回对应下表的节点的数据
     * @param index
     * @return
     */
    public String getValueByIndex(int index){
        return vertexList.get(index);
    }

    public void show(){
        for(int []link:edges){
            System.err.println(Arrays.toString(link));
        }
    }

    /**
     *
     * @param v1 表示节点的下标
     * @param v2
     * @param weight
     */
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
        graph.DFS(new boolean[graph.getNumOfVertexSize()], 0);
        System.out.println("-------------------------");
        graph.BFS(0,new LinkedList<Integer>(),new boolean[graph.getNumOfVertexSize()]);
    }



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

    public void BFS(int start,Queue<Integer> queue,boolean []isVisited){
        if(!isVisited[start]){
            System.out.println(getValueByIndex(start));
            isVisited[start]=true;
        }
        // 遍历邻接节点
        for(int i=0;i<getNumOfVertexSize();i++){
            if(edges[start][i]!=0&&!isVisited[i]){
                System.out.println(getValueByIndex(i));
                isVisited[i]=true;
                queue.offer(i);
            }
        }
        Integer head = queue.poll();
        if(head!=null){
            BFS(head,queue,isVisited);
        }

    }
}
