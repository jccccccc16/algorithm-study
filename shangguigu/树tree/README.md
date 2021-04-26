时间复杂度 logn

#### 二叉树 

所有叶子节点都在最后一层节点数 2^n-1

满二叉树

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210426105246162.png)

完全二叉树

倒数第二层的叶子节点连续

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210426105311123.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDc3MTU4Mg==,size_16,color_FFFFFF,t_70)

##### 遍历

前序遍历就是先遍历父节点，中序就是父节点在中

###### 前序遍历

先输出当前节点

如果左节点不为空，那么递归前序遍历左节点

如果右节点不为空，那么递归前序遍历右节点



###### 中序遍历

###### 后序遍历





#### 线索化二叉树

