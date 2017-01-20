package com.yiyo.study.search;

/**
 * Average Case: O(log(n))
 * Worst Case: O(n) in unbalanced trees
 *
 * Created by Yiyo
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
    }

    public Node insert(Node root, int value) {
        if (root == null) {
            root = new Node(value);
        } else if (value <= root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public boolean search(Node root, int value) {
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

    public class Node {
        public Node left;
        public Node right;
        public int data;

        public Node(int data) {
            this.data = data;
        }
    }
}
