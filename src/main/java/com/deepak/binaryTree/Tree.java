package com.deepak.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tree {
    TreeNode root;

    public void insert(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no of levels in the tree: ");
        int n = sc.nextInt();
        n = (int)(Math.pow(2,n)) - 1;
        Queue<TreeNode> q = new LinkedList<>();
        while(n > 0){
            System.out.print("Enter the value of node: ");
            String val = sc.next();
            if(val.equals("-")){
                q.add(null);
            }
            else{
                int newVal = Integer.parseInt(val);
                q.add(new TreeNode(newVal));
            }
            n--;
            System.out.println();
        }
//        System.out.println(q);
        while(!q.isEmpty()){

        }

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
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
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
