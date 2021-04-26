import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/4/25
 * Time: 23:20
 * To change this template use File | Settings | File Templates.
 * 手写简单哈希表
 **/
public class MyHash {

    private int initSize =20;
    private LinkTable[] linkTables = new LinkTable[initSize];

    public MyHash(){

    }

    /**
     *
     * @param id
     * @return
     */
    //Todo
    public Emp get(int id){
        Emp target = new Emp(id, null);
        int hashCode = Objects.hash(id);
        int index = Integer.valueOf(hashCode%20);
        LinkTable linkTable = linkTables[index];
        // 遍历该链表
        if(linkTable==null){
            return null;
        }else{
            MyNode myNode = linkTable.head;
            while(myNode!=null){
                Emp data = myNode.data;
                if(data.equals(target)){
                    return data;
                }
                myNode = myNode.next;
            }
        }
        return null;
    }

    public  boolean isEqual(Emp source,Emp target){
        return source.equals(target);
    }

    public static void main(String[] args) {
//        Emp cjc = new Emp(2, "cjc");
//        Emp cjc2 = new Emp(2, "111");
//        boolean equals = isEqual(cjc,cjc2);
//        System.out.println(equals);
        MyHash myHash = new MyHash();
        myHash.add(new Emp(45, "cjc"));
        myHash.add(new Emp(48, "cjc1"));
        myHash.add(new Emp(59, "cjc2"));
        myHash.add(new Emp(25, "cjc3"));
        Emp emp = myHash.get(45);
        System.out.println(emp!=null?emp.toString():"找不到emp");

    }


    public void add(Emp emp){
        // 计算哈希值，确定要保存在哪个linkTable中，
        int hashCode = emp.hashCode();
        int linkTableIndex = Integer.valueOf(hashCode%initSize);
        if(null==linkTables[linkTableIndex]){
            LinkTable linkTable = new LinkTable();
            linkTables[linkTableIndex] = linkTable;
            MyNode myNode = CreateNode(emp, null);
            linkTables[linkTableIndex].head = myNode;
            linkTables[linkTableIndex].tail = myNode;
        }else{
            linkTables[linkTableIndex].add(emp);
        }
    }

    // 链表
    private class LinkTable{
        // 第一个
        private MyNode head;
        private MyNode tail;
        public void add(Emp emp){
            MyNode myNode = CreateNode(emp, null);

            tail.next = myNode;
            tail =myNode;


        }
    }
    private MyNode CreateNode(Emp emp,MyNode next){
        return new MyNode(emp,next);
    }
    private  class MyNode{
        private Emp data;
        private MyNode next;

        public MyNode(Emp data, MyNode next) {
            this.data = data;
            this.next = next;
        }

        public Emp getData() {
            return data;
        }

        public void setData(Emp data) {
            this.data = data;
        }

        public MyNode getNext() {
            return next;
        }

        public void setNext(MyNode next) {
            this.next = next;
        }
    }


}
