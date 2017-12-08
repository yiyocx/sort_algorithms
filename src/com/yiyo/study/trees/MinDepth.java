package com.yiyo.study.trees;

public class MinDepth {

    /*
    Given a binary tree, find its minimum depth.
    The minimum depth is the number of nodes along the
    shortest path from the root node down to the nearest leaf node.
     */

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.insert(null, 100);
        bst.insert(root, 98);
        bst.insert(root, 102);
        bst.insert(root, 96);
        bst.insert(root, 97);
        bst.insert(root, 99);

        MinDepth md = new MinDepth();
        System.out.println(md.minDepth(root));
    }

    private int minDepth(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + Math.min(
                root.left == null ? Integer.MAX_VALUE : minDepth(root.left),
                root.right == null ? Integer.MAX_VALUE : minDepth(root.right)
        );
    }
}
