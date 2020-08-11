package com.todo.erchashu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 递归遍历
 * 左、右、根（是根右左的反序）
 */
class Solution0145 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorder(TreeNode root) {
        if(root == null) return list;
        return helper(root);
    }
    private List<Integer> helper(TreeNode root){
        if(root.left != null)
            helper(root.left);
        if(root.right != null)
            helper(root.right);
        list.add(root.val);
        return list;
    }
}

/**
 * 迭代遍历
 */
class Solution0145_2 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorder(TreeNode root) {
        if(root == null) return list; // 可有可无
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            if(root != null){
                list.add(root.val);
                stack.push(root);
                root = root.right;
            } else{
                root = stack.pop();
                root = root.left;
            }
        }
        Collections.reverse(list);
        return list;
    }
}

public class LC0145 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,5,null};
        TreeNode root = new TreeNode().buildTree(arr);
        List<Integer> list = new Solution0145().postorder(root);
        System.out.println("递归："+list);

        List<Integer> list2 = new Solution0145_2().postorder(root);
        System.out.println("迭代："+list2);
    }
}
