## 步骤

- 分解成若干子问题

- 每个子问题通过贪心策略进行求解（都选择采取最好的或者最优的）

- 组合子问题的解



## 硬币找零

简单的案例

```java
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
```



## 集合覆盖问题

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210625193009593.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDc3MTU4Mg==,size_16,color_FFFFFF,t_70)

- 先定义一个set用来装覆盖地区，一个list用来装广播台
- 用set与其他的电台进行或运算，结果覆盖地区最多的电台，加入到list中，地区添加到set中
- 剔除该电台
- 递归操作



## 普利姆算法

### 场景：修路

图的最小生成树

- 在图中找出，联通所有节点，且边上的权总和最小，称为最小生成树

- N个顶点，N-1个边

普利姆算法就是找最小生成树的算法

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210626141227306.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDc3MTU4Mg==,size_16,color_FFFFFF,t_70)

- 一个空的顶点集合集合，加入A顶点< A >

- **遍历集合中的所有顶点的邻接节点**，找出没有访问过的，且权值最小的节点，比如C：7，G：2，B：5
- G的权值最小，所以将G添加到结合中，<A,D>，继续重复2步骤
- 直到集合中包含所有顶点为止。

## 克鲁斯卡尔算法

也是一个最小生成树算法

基本思想：一个只含n个顶点的森林（也就是图没有了边），按照权值从小到大的顺序选择n-1条边，并保证这n-1条边不构成回路

两个重点：

- 排序 

- 如何判断回路
- 什么时候停止

![1624712362887](C:\Users\cjc\AppData\Roaming\Typora\typora-user-images\1624712362887.png)

![1624713019218](C:\Users\cjc\AppData\Roaming\Typora\typora-user-images\1624713019218.png)

![1624713075594](C:\Users\cjc\AppData\Roaming\Typora\typora-user-images\1624713075594.png)

https://www.bilibili.com/video/BV1Eb41177d1?from=search&seid=3831552557486774515最好的视频教程

算法的步骤：

- 将边按权值，由小到大排序
- 依次选择边，判断是否与已有边存在环，如果不，填入图中。
- 直到选中的边数为Node - 1

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210626212629632.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDc3MTU4Mg==,size_16,color_FFFFFF,t_70)

判断是否成环的算法？

第一步：F的终点是F，E是F，

2：C的终点是C，D是C

3：对于D和E，D是C，E是F，添加该边之后，（随机对一个顶点的终点更新）,比如是更新D的重点，为E的终点，也就是F，那这样的话，到了<C,F>这条边时，C的终点是C，然后F的终点是F，那么不就形成回路了吗？

答：其实在获取我们的边时，获取二维数组的右上三角，都是从小指向大的顶点（大小指的是二维数组中的序号）<小，大>，比如A,B,C,D,E,F,G，在我们的二维数组中也是这样排序的。所以在选择边添加到森林中时，更新终点时，**都是在更新小的一方的终点，将小的终点更改为大的终点**,**小的终点指向大的终点**。

![在这里插入图片描述](https://img-blog.csdnimg.cn/2019082909412672.jpeg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQxODE5OTg4,size_16,color_FFFFFF,t_70)

总结判断成环：

一个表用来记录每一个顶点的终点所在位置的下标.（传递）

比如，[1,2,3,5,0,0,0,]，这里记录了A的终点的下标为1，下标为1的值为2，下标为2的值为3.。。。，直到找到0为止

以上图为例：

<E,F>，E的终点为F，F为F，那么[0,0,0,0,4,5,0]

<C,D>，C的终点为D，D的终点为D，那么[0,0,3,3,5,5,0]

**关键**，

<D,E>，边，E的终点查表得下标为5，下标为5的值为5，也即是F，

D的终点查表得下标为3，下标为3的值为3，那么不形成环，**更新小的顶点的终点**，也就是更新D的终点，更新为E的终点，[0,0,3,5,5,5,0]，离散数学中的传递，C的终点下标为3，3的值为5，5的值为5



- 查找表，不断根据下标找到该下标对应的值，也就是在传递地查找终点
- 直到为值为0



## 迪杰斯特拉算法

最短路径问题

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210627224536883.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDc3MTU4Mg==,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210627225807977.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDc3MTU4Mg==,size_16,color_FFFFFF,t_70)

**因为广度优先是可以一层一层的遍方，那么就可以在每一层进行计算，基于筛选的过程（贪心策略），，直到遍历到了终点**



两个重要的数据

- 一个用于保持起点到当前节点的距离的一维数组 minDistance[]（可能会拗口，看视频https://www.bilibili.com/video/BV1q4411M7r9?from=search&seid=14090253313449159054）
- isVisit   boolean[]
- parent，遍历parent得到路径节点



过程

（1）遍历当前节点A的邻接节点B，将当前节点isVisit设置为true

（2）<A,B>取该边的权值 + 起点到当前节点A的距离 与 一维数组中B的最小距离（有点拗口）

比如

minDistance[B]+matrix[B] [C]<minDistance[C]

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210628135615344.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDc3MTU4Mg==,size_16,color_FFFFFF,t_70)

（3）从minDistance中，选出 没有被访问过的，并且minDistance中权值最小的节点，作为当前节点，重复（1）



## 弗洛伊德算法

也是最短路径算法，