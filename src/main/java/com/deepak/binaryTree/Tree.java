package com.deepak.binaryTree;

import java.util.*;

public class Tree<T> {
    TreeNode root;

    public void insertTreeNode(T val){

    }

    public void createTree(){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        String[] nodesStr = input.split(",");
        List<TreeNode<T>> nodes = new LinkedList<>();
        for(String str: nodesStr){
            if(str.equals("null")){
               nodes.add(null);
            }
            else{
                 TreeNode<T> curr=  new TreeNode<>((T) str);
                nodes.add(curr);
            }
        }
        for(int i=0;i< nodes.size();i++){
            if(root==null && i==0){
                root = nodes.get(0);
            }
            if(nodes.get(i)!=null){
            if(((2*i)+1)< nodes.size()){
                nodes.get(i).left = nodes.get(2*i+1);
            }
            if(((2*i)+2)< nodes.size()){
                nodes.get(i).right = nodes.get(2*i+2);
            }
            }

        }
    }

    public void printTreeHelper(TreeNode<T> root){
        if(root == null){
            return;
        }
        if(root.left!=null){
            System.out.println(root.val + " left child: " + root.left.val);

        }
        if(root.right!=null){
            System.out.println(root.val + " right child: " + root.right.val);

        }

        printTreeHelper(root.left);
        printTreeHelper(root.right);

    }

    public void printTree(){
        TreeNode<T> curr = root;
        printTreeHelper(root);

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
