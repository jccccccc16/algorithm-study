import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil;

import javax.swing.*;
import java.util.Comparator;
import java.util.function.Predicate;

/**
 * Created by IntelliJ IDEA.
 * User: cjc
 * Date: 2021/4/26
 * Time: 11:05
 * To change this template use File | Settings | File Templates.
 * 我滴二叉树
 **/
public class MyBinaryTree {

    private MyNode root = null;

    public static final ComparatorType DEFAULT_COMPARATOR=ComparatorType.AGE_COMPARATOR;

    private MyComparator comparator;

    public void preOrder(){
        if(this.root!=null){
            this.root.preOrder();
        }
    }

    public MyBinaryTree(){
        this.comparator = createComparator(DEFAULT_COMPARATOR);
    }
    public MyBinaryTree(ComparatorType comparatorType){
        this.comparator = createComparator(comparatorType);
    }

    public enum ComparatorType{
        AGE_COMPARATOR,ID_COMPARATOR
    }


    private  MyComparator createComparator(ComparatorType comparatorType){
        MyComparator comparator;
            switch (comparatorType){
                case AGE_COMPARATOR:
                    comparator = (node1,node2)->{
                        if(node1.getAge()>=node2.getAge()){
                            return true;
                        }else{
                            return false;
                        }
                    };
                    break;
                case ID_COMPARATOR:
                    comparator  = (node1,node2)->{
                        if(node1.getId()>=node2.getId()){
                            return true;
                        }else{
                            return false;
                        }
                    };
                    break;
                default:
                    comparator = null;
            }
            return comparator;
    }

    public interface  MyComparator{
        public boolean compare(MyNode node1,MyNode node2);
    }




    public void add(int id,String name,int age){
        MyNode myNode = new MyNode(id,name,age);
        if(this.root==null){
            this.setRoot(myNode);
        }else{
            MyNode node = root;
            MyNode pre = null;
            boolean isRight = true;
            while(node!=null){
                pre = node;
                //ToDo 更改策略
                if(!comparator.compare(myNode,node)){
                    node = node.getLeft();
                    isRight = false;
                    continue;
                }
                if(comparator.compare(myNode,node)){
                    node = node.getRight();
                    isRight = true;
                }
            }
            if (isRight) {
                pre.setRight(myNode);
            } else {
                pre.setLeft(myNode);
            }
        }
    }



    private MyNode getRoot() {
        return root;
    }

    private void setRoot(MyNode root) {
        this.root = root;
    }

    public MyNode searchByIdDG(int id){
        MyNode node = this.root;
        return searchByIdDG0(id,node);
    }

    private MyNode searchByIdDG0(int id,MyNode node){
        if(node!=null){
            if(id>node.getId()){
                if(node.getRight()!=null){
                    node = node.getRight();
                    return searchByIdDG0(id,node);
                }
            }else if(id<node.getId()){
                if(node.getLeft()!=null){
                    node = node.getLeft();
                    return searchByIdDG0(id,node);
                }
            }else{
                return node;
            }
        }
        return null;
    }

    public MyNode searchById(int id){
        if(this.root==null){
            return null;
        }else{
            MyNode node = root;
            while(node!=null){
                if(id>node.getId()){
                    if(node.getRight()!=null){
                        node = node.getRight();
                    }else{
                        break;
                    }
                }else if(id<node.getId()){
                    if(node.getLeft()!=null){
                        node = node.getLeft();
                    }else{
                        break;
                    }
                }else{
                    return node;
                }
            }
            return null;
        }
    }




    public class MyNode{
        private String name;
        private int age;
        private int id;
        private MyNode left;
        private MyNode right;

        public MyNode(int id,String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.left = null;
            this.right = null;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public MyNode getLeft() {
            return left;
        }

        public void setLeft(MyNode left) {
            this.left = left;
        }

        public MyNode getRight() {
            return right;
        }

        public void setRight(MyNode right) {
            this.right = right;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
        // 前序遍历
        public void preOrder(){
            System.out.println(this.toString());
            // 递归遍历左节点
            if(this.left!=null){
                this.left.preOrder();
            }
            // 递归遍历右节点
            if(this.right!=null){
                this.right.preOrder();
            }
        }

        // 中序遍历
        public void infixOrder(){

            // 递归遍历左节点
            if(this.left!=null){
                this.left.infixOrder();
            }
            System.out.println(this.toString());
            // 递归遍历右节点
            if(this.right!=null){
                this.right.infixOrder();
            }
        }
        // 后续遍历
        public void postOrder(){

            // 递归遍历左节点
            if(this.left!=null){
                this.left.postOrder();
            }

            // 递归遍历右节点
            if(this.right!=null){
                this.right.postOrder();
            }
            System.out.println(this.toString());
        }

        @Override
        public String toString() {
            return "MyNode{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", id=" + id +
                    '}';
        }
    }



    public static void main(String[] args) {
////        默认策略为以age大小来排
//        MyBinaryTree myBinaryTree1 = new MyBinaryTree();
//        myBinaryTree1.add(12,"cjc"+12,12);
//        myBinaryTree1.add(13,"cjc"+13,13);
//        myBinaryTree1.add(45,"cjc"+45,45);
//        myBinaryTree1.add(11,"cjc"+11,11);
//        myBinaryTree1.preOrder();
////        以id大小来排
//        MyBinaryTree myBinaryTree = new MyBinaryTree(ComparatorType.ID_COMPARATOR);
//        myBinaryTree.add(12,"cjc"+12,12);
//        myBinaryTree.add(13,"cjc"+13,13);
//        myBinaryTree.add(45,"cjc"+45,45);
//        myBinaryTree.add(11,"cjc"+11,11);
//        myBinaryTree.preOrder();
        MyBinaryTree myBinaryTree = new MyBinaryTree(ComparatorType.ID_COMPARATOR);
        myBinaryTree.add(12,"cjc"+12,12);
        myBinaryTree.add(13,"cjc"+13,13);
        myBinaryTree.add(45,"cjc"+45,45);
        myBinaryTree.add(11,"cjc"+11,11);
        myBinaryTree.preOrder();
        MyNode myNode = myBinaryTree.searchByIdDG(11);
        System.out.println(myNode!=null?"找到该节点 "+myNode.toString():"null");

    }

}
