排序分类

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210426205728854.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDc3MTU4Mg==,size_16,color_FFFFFF,t_70)

### 时间频度和时间复杂度

时间频度：算法花费的时间与算法中语句的执行次数成正比例

T（n）

#### 频度计算

for = n + 1

直接计算 为1 

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210426210609660.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDc3MTU4Mg==,size_16,color_FFFFFF,t_70)

忽略常数项和系数，由于函数增长趋势相近

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210426210812145.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDc3MTU4Mg==,size_16,color_FFFFFF,t_70)

#### 时间复杂度

频度保留只保留最高项，

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210426221024202.png)

### 排序算法

#### 冒泡排序

谁大谁往后打擂台

![在这里插入图片描述](https://img-blog.csdnimg.cn/2021042622441141.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80NDc3MTU4Mg==,size_16,color_FFFFFF,t_70)

一次比较，最大值排最后

```java
 for(int i=0;i<nums.length-1;i++){
                if(nums[i]>nums[i+1]) {
                    int temp;
                    temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }
            }
```

要排序完，需要进行n次比较

```java
 for(int j=0;j<nums.length;j++){
            for(int i=0;i<nums.length-1-j;i++){
                if(nums[i]>nums[i+1]) {
                    int temp;
                    temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }
            }
        }
```

冒泡排序的优化

如果有一趟的比较没有发生交换，那么我们就认为该数组已经是有序的了

#### 选择排序

选择后面小的与当前位置互换

![在这里插入图片描述](https://images2017.cnblogs.com/blog/849589/201710/849589-20171015224719590-1433219824.gif)

往后选，当前位置出发，选择最小的放到当前位置

#### 插入排序

![在这里插入图片描述](https://images2017.cnblogs.com/blog/849589/201710/849589-20171015225645277-1151100000.gif)

前面的数认为是有序的，把当前数与前面对比



#### 归并排序

![在这里插入图片描述](https://images2017.cnblogs.com/blog/849589/201710/849589-20171015230557043-37375010.gif)

归并排序，使用分治算法

先先切开两半，然后递归左边（一直递归到数据只有一个数，或者为空），再递归右边，然后合并排序

**将左边一直切，一直切，切到只有一个，**

**右边同理，**

那么比如递归的最后一左右切成了只有一个，比如left[] = 2, right[] = 3

然后两个数合并然后排序，返回，如此类推

```java
public static int[] sort(int[] nums){

    	// 基线条件
    	// 递归停止之时，你想要切成什么样，当然是切成只有一个值，或者没有拉，那就停止了
        if(nums.length<2){
            return nums;
        }
    	// 切两半
        int middle = (int)(nums.length/2);
        CutMapper cutMapper =cut(nums,middle);
        int[] leftNums = cutMapper.getLeft();
        int[] rightNums = cutMapper.getRight();
        // 递归左边
    	int[] leftResult = sort(leftNums);
        // 递归右边
    	int[] rightResult = sort(rightNums);
        // 合并排序最终结果，返回之
    	return merge(leftResult,rightResult);
    }
```

步走：

- 我想要递归成什么样 （基线条件），比如归并，我想要左右递归成只有一个数，那么两个数排序合并就简单了

- 递归左边
- 递归右边
- 操作