package com.todo.erchashu;

import java.util.ArrayList;
import java.util.List;

class TreeNode{
    Integer val;
    TreeNode left;
    TreeNode right;
    // 无参的构造函数
    public TreeNode(){}
    // 构造一个TreeNode节点
    public TreeNode(Integer val){
        this.val = val;
    }
    // 传入arr 构造整棵树，返回根节点
    public TreeNode buildTree(Integer[] arr){
        //为了方便就不判断arr的合法性了
        List<TreeNode> list = new ArrayList<>();
        for(Integer each:arr){
            list.add(new TreeNode(each));
        }
        for(int i=0; i<arr.length; i++){
            if(2*i+1 < arr.length)
                list.get(i).left = list.get(2*i+1);
            if(2*i+2 < arr.length)
                list.get(i).right = list.get(2*i+2);
        }
        return list.get(0);
    }
}
public class Utils{
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,5,null};
        TreeNode root = new TreeNode().buildTree(arr);
    }
}

