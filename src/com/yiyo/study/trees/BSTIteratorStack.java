package com.yiyo.study.trees;

import java.util.Iterator;
import java.util.Stack;

/**
 * Time complexity: O(1) on average
 * Space complexity: O(h)
 * This only requires memory equivalent to the length of the path which is the depth of the tree
 */
public class BSTIteratorStack implements Iterator<Integer> {

    /*
    Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

    The first call to next() will return the smallest number in BST.
    Calling next() again will return the next smallest number in the BST, and so on.

    Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
    Try to optimize the additional space complexity apart from the amortized time complexity.
     */
    public static void main(String[] args) {
        BinarySearchTree searchTree = new BinarySearchTree();
        TreeNode root = searchTree.insert(null, 15);
        searchTree.insert(root, 10);
        searchTree.insert(root, 20);
        searchTree.insert(root, 25);
        searchTree.insert(root, 8);
        searchTree.insert(root, 12);

        BSTIteratorStack iterator = new BSTIteratorStack(root);
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }

    private Stack<TreeNode> stack = new Stack<>();

    BSTIteratorStack(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    @Override
    public Integer next() {
        TreeNode node = stack.pop();
        int result = node.data;

        if (node.right != null) {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return result;
    }
}
