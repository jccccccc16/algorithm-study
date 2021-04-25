二分查找
left 与right 无论何时都是源数据中的下表,原数组没有发生变化
left 与 right 两个指针，控制middle的变化，当left>right，为基线

left = 0，

right = length - 1
nums[middle] = target 为基线
如果大于nums[middle]

那么left = middle+1

否则middle = right -1





斐波那契查找法

对于二分查找法来说说，优化都是关注在如何优化middle，使得middle尽量往我们目标数靠近，那么二分操作就会减少

对于斐波那契：

斐波那契，前一个数位与后一个数相比位黄金比例

如何去定义middle，根据斐波那契，将数组进行黄金分割，设总长度为F(k)-1我们的middle是在黄金分割的附近，那么下标为low+f(k-1)-1

步骤

1. 找到大于数组长度的斐波那契数f[k]，

2. 创建一个长度为斐波那契数的临时数组，超出的部分使用nums[high]填充
3. 计算middle = low + f[k-1]-1

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210425211534386.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDc3MTU4Mg==,size_16,color_FFFFFF,t_70)

