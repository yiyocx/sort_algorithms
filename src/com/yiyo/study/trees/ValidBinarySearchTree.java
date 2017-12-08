package com.yiyo.study.trees;

/**
 * Time complexity: O(n)
 */
public class ValidBinarySearchTree {

    /*
    Given a binary tree, determine if it is a valid binary search tree (BST).

    Assume a BST is defined as follows:

    - The left subtree of a node contains only nodes with keys less than the node’s key.
    - The right subtree of a node contains only nodes with keys greater than the node’s key.
    - Both the left and right subtrees must also be binary search trees.
     */
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode rootA = bst.insert(null, 7);
        bst.insert(rootA, 4);
        bst.insert(rootA, 9);
        bst.insert(rootA, 1);
        bst.insert(rootA, 6);

        TreeNode rootB = new TreeNode(3);
        rootB.left = new TreeNode(4);
        rootB.right = new TreeNode(2);
        bst.insert(rootB.left, 1);
        bst.insert(rootB.right, 5);

        ValidBinarySearchTree validate = new ValidBinarySearchTree();
        System.out.println(validate.isValidBST(rootA));
        System.out.println(validate.isValidBST(rootB));
    }

    private boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }

        return root.data > minValue && root.data < maxValue
                && isValidBST(root.left, minValue, root.data)
                && isValidBST(root.right, root.data, maxValue);
    }
}
