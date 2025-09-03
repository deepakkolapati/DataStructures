package com.deepak.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tree {
    TreeNode root;

    public void insert(){
        Scanner sc = new Scanner(System.in);



    }

    public boolean hasPathSum(TreeNode root, Integer targetSum) {
    /**   Given the root of a binary tree and an integer targetSum,
      return true if the tree has a root-to-leaf path such that
      adding up all the values along the path equals targetSum.
      A leaf is a node with no children. **/
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null && root.val == targetSum){
            return true;
        }
        return hasPathSum(root.left, targetSum - (Integer)root.val) || hasPathSum(root.right, targetSum - (Integer)root.val);
    }
}
