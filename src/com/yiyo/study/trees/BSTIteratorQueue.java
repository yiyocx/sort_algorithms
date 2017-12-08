package com.yiyo.study.trees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Time complexity: O(1)
 * Space complexity: O(n)
 * This has an additional space of O(n). This is acceptable but the BSTIteratorStack has a most space efficient solution
 */
public class BSTIteratorQueue implements Iterator<Integer> {

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

        BSTIteratorQueue iterator = new BSTIteratorQueue(root);
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }

    private Queue<TreeNode> queue = new LinkedList<>();

    BSTIteratorQueue(TreeNode root) {
        inOrder(root);
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        queue.add(root);
        inOrder(root.right);
    }

    /**
     * @return whether we have a next smallest number
     */
    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    @Override
    public Integer next() {
        return queue.poll().data;
    }
}
