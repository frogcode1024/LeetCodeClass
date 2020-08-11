package com.todo.erchashu;
import java.util.*;
//中序遍历 左、根、右
/**
 * 递归遍历
 */
class Solution0094 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return list;
        return helper(root);
    }
    private List<Integer> helper(TreeNode root){
        if(root.left != null)
            helper(root.left);
        list.add(root.val);
        if(root.right != null)
            helper(root.right);
        return list;
    }
}

/**
 * 迭代遍历
 */
class Solution0094_2 {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }
}
public class LC0094 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,4,5,null};
        TreeNode root = new TreeNode().buildTree(arr);
        List<Integer> list = new Solution0094().inorderTraversal(root);
        System.out.println("递归："+list);

        List<Integer> list2 = new Solution0094_2().inorderTraversal(root);
        System.out.println("迭代："+list2);
    }
}
