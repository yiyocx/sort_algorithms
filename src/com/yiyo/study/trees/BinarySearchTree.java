package com.yiyo.study.trees;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Average Case: O(log(n)) for search, insertion and delete
 * Worst Case: O(n) in unbalanced trees
 */
public class BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree searchTree = new BinarySearchTree();
        Node root = searchTree.insert(null, 15);
        searchTree.insert(root, 10);
        searchTree.insert(root, 20);
        searchTree.insert(root, 25);
        searchTree.insert(root, 8);
        searchTree.insert(root, 12);

        System.out.println(searchTree.search(root, 25));
        System.out.println(searchTree.search(root, 33));

        System.out.println("Tree in Level Order:");
        searchTree.levelOrder(root);
    }

    Node insert(Node root, int value) {
        if (root == null) {
            root = new Node(value);
        } else if (value <= root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    private boolean search(Node root, int value) {
        if (root == null) {
            return false;
        } else if (root.data == value) {
            return true;
        } else if (value < root.data) {
            return search(root.left, value);
        } else {
            return search(root.right, value);
        }
    }

    private Node delete(Node root, int value) {
        if (root == null) {
            return root;
        } else if (value < root.data) {
            root.left = delete(root.left, value);
        } else if (value > root.data) {
            root.right = delete(root.right, value);
        } else {
            // Case 1: No child
            if (root.left == null && root.right == null) {
                root = null;
            }
            // Case 2: One child
            else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            }
            // Case 3: Two children
            else {
                Node temp = findMin(root.right);
                root.data = temp.data;
                root.right = delete(root.right, temp.data);
            }
        }
        return root;
    }

    private Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Time complexity: O(log(n))
    private void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node element = queue.poll();
            System.out.print(element.data + " ");

            if (element.left != null) {
                queue.add(element.left);
            }

            if (element.right != null) {
                queue.add(element.right);
            }
        }
    }

    public class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }
}
