package com.yiyo.study.trees;

/**
 * Time complexity: O(n) for all traversals here
 * Space complexity: O(h) height of the tree
 */
public class DepthTraversals {

    public static void main(String[] args) {
        BinarySearchTree searchTree = new BinarySearchTree();
        TreeNode root = searchTree.insert(null, 15);
        searchTree.insert(root, 10);
        searchTree.insert(root, 20);
        searchTree.insert(root, 25);
        searchTree.insert(root, 8);
        searchTree.insert(root, 12);

        DepthTraversals depthTraversals = new DepthTraversals();
        System.out.println("Pre order:");
        depthTraversals.preOrder(root);
        System.out.println("\n\nIn order:");
        depthTraversals.inOrder(root);
        System.out.println("\n\nPost order:");
        depthTraversals.postOrder(root);
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    private void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
}
