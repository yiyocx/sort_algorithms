package com.yiyo.study.trees;

public class LeastCommonAncestor {

    /*
    Find the lowest common ancestor in an unordered binary tree given two values in the tree.
    Lowest common ancestor : the lowest common ancestor (getLCA) of two nodes v and w in a tree or
    directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants.

    You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
    No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
    There are no duplicate values.
    You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.
     */
    public static void main(String[] args) {
        LeastCommonAncestor node = new LeastCommonAncestor();
        TreeNode A = new TreeNode(3);
        A.left = new TreeNode(6);
        A.left.left = new TreeNode(2);
        A.left.right = new TreeNode(11);
        A.left.right.left = new TreeNode(9);
        A.left.right.right = new TreeNode(5);
        A.right = new TreeNode(8);
        A.right.right = new TreeNode(13);
        A.right.right.left = new TreeNode(7);

        System.out.println(node.lca(A, 2, 8));
        System.out.println(node.lca(A, 2, 5));
        System.out.println(node.lca(A, 9, 5));
        System.out.println(node.lca(A, 8, 7));
        System.out.println(node.lca(A, 9, 3));
    }

    private int lca(TreeNode A, int B, int C) {
        if (!nodeExists(A, B) || !nodeExists(A, C)) {
            return -1;
        }

        TreeNode ancestor = getLCA(A, B, C);
        return ancestor != null ? ancestor.data : -1;
    }

    private TreeNode getLCA(TreeNode A, int B, int C) {
        if (A == null) {
            return null;
        }

        if (A.data == B || A.data == C) {
            return A;
        }

        TreeNode left = getLCA(A.left, B, C);
        TreeNode right = getLCA(A.right, B, C);

        if (left != null && right != null) {
            return A;
        }
        return left != null ? left : right;
    }

    private boolean nodeExists(TreeNode A, int val) {
        if (A == null) {
            return false;
        }
        if (A.data == val) {
            return true;
        }
        boolean left = nodeExists(A.left, val);
        boolean right = nodeExists(A.right, val);
        return left || right;
    }
}
