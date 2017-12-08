package com.yiyo.study.trees;

public class MaxDepth {

    /*
    Given a binary tree, find its maximum depth.
    The maximum depth of a binary tree is the number of nodes along
    the longest path from the root node down to the farthest leaf node.
     */
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.insert(null, 100);
        bst.insert(root, 98);
        bst.insert(root, 102);
        bst.insert(root, 96);
        bst.insert(root, 97);
        bst.insert(root, 99);

        MaxDepth md = new MaxDepth();
        System.out.println(md.maxDepth(root));
        assert 4 == md.maxDepth(root);
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
