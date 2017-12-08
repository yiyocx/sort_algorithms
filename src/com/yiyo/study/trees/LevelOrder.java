package com.yiyo.study.trees;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Time complexity: O(log(n))
 * Space complexity: O(1)
 */
public class LevelOrder {

    public static void main(String[] args) {
        BinarySearchTree searchTree = new BinarySearchTree();
        TreeNode root = searchTree.insert(null, 15);
        searchTree.insert(root, 10);
        searchTree.insert(root, 20);
        searchTree.insert(root, 25);
        searchTree.insert(root, 8);
        searchTree.insert(root, 12);

        System.out.println("Tree in Level Order:");
        LevelOrder lo = new LevelOrder();
        lo.levelOrder(root);
    }

    void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode element = queue.poll();
            System.out.print(element.data + " ");

            if (element.left != null) {
                queue.add(element.left);
            }

            if (element.right != null) {
                queue.add(element.right);
            }
        }
    }
}
