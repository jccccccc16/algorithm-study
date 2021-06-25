### 解决问题

求解优化问题

最大，最小，最。。

### 动态规划背包问题

打表

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210507101742556.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDc3MTU4Mg==,size_16,color_FFFFFF,t_70)

**运作**

**能放进来：判断上一个，与我的价值和上一层剩余的重量的价值，两者的最大值**

当物品为吉他时：

​	当前背包为0磅，不可以放入，当为1磅时可以放入，当2磅时可以放入。。

当物品为音响：

​	当背包为1磅时，放不进音响，取上面一个单元；

​	当背包为4磅时，发现可以放入音响，那么放入音响

当物品为电脑：

​	当背包为3磅时，放入电脑；

​	当背包为4磅时，判断上一个单元，与电脑和吉他（为何选择吉他，因为放入电脑，然后当前背包减去电脑重量还剩1磅只有吉他），比较他们谁的价值大

**公式**(重要)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210507101842330.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDc3MTU4Mg==,size_16,color_FFFFFF,t_70)



### 解

- 穷举

- 递归+记忆+猜测（判断）

### 斐波那契

不使用动态规划

```java
public static int fib(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }

```

使用动态规划

```java
private static Map<Integer,Integer> memoMap = new HashMap<>();
 public static int fibDP(int n){
        if(memoMap.get(n)!=null){
            return memoMap.get(n);
        }
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int fib = fib(n-1)+fib(n-2);
        memoMap.put(n,fib);
        return fib;
    }
```

看看斐波那契递归原理

将计算结果存放在表中I（记忆），如果表中有那么直接返回（猜测）

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210507110730579.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDc3MTU4Mg==,size_16,color_FFFFFF,t_70)

所以，如何改进一个普通的递归算法，了解原理，是否可以记忆



拆分子问题

记录子问题的解到表中，子问题的解又能到表中查询到

 **取决于该问题是否能用动态规划解决的是这些”小问题“会不会被被重复调用。** 



### KMP

两个东西

###### 匹配表（重点）

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210507211116715.png)

###### 如何得到部分匹配值

前缀集合和后缀集合的最长子集长度（字符串首和字符串中有相同部分）

细品(当扫描到的部分首在字符串中有没有相同部分)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210507211229429.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDc3MTU4Mg==,size_16,color_FFFFFF,t_70)

也就是说当进行匹配时，匹配的字符串中前后有相同，那么当不匹配时，就跳到已扫描的相同的部分开始，从而避免暴力匹配

比如，当扫描到“ ”和D时，发现不匹配，那么跳到AB开始再进行扫描

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210507211525729.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDc3MTU4Mg==,size_16,color_FFFFFF,t_70)

###### 如何跳？（重点）

扫描的当前位置-部分匹配表中的值 = 所跳的位置

比如 6 - 2 = 4，应该往后移4位