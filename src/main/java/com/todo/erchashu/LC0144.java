package com.todo.erchashu;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 递归遍历
 * 根、左、右
 */
class Solution0144 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(TreeNode root) {
        if(root == null) return list;
        return helper(root);
    }
    private List<Integer> helper(TreeNode root){
        list.add(root.val);
        if(root.left != null)
            helper(root.left);
        if(root.right != null)
            helper(root.right);
        return list;
    }
}

/**
 * 迭代遍历
 */
class Solution0144_2 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(TreeNode root) {
        if(root == null) return list; // 可有可无
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            if(root != null){
                list.add(root.val);
                stack.push(root);
                root = root.left;
            } else{
                root = stack.pop();
                root = root.right;
            }
        }
        return list;
    }
}
public class LC0144 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,5,null};
        TreeNode root = new TreeNode().buildTree(arr);
        List<Integer> list = new Solution0144().preorder(root);
        System.out.println("递归："+list);

        List<Integer> list2 = new Solution0144_2().preorder(root);
        System.out.println("迭代："+list2);
    }
}
