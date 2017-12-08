package com.yiyo.study.trees;

/**
 * Average Case: O(log(n)) for search, insertion and delete
 * Worst Case: O(n) in unbalanced trees
 */
public class BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree searchTree = new BinarySearchTree();
        TreeNode root = searchTree.insert(null, 15);
        searchTree.insert(root, 10);
        searchTree.insert(root, 20);
        searchTree.insert(root, 25);
        searchTree.insert(root, 8);
        searchTree.insert(root, 12);

        System.out.println(searchTree.search(root, 25));
        System.out.println(searchTree.search(root, 33));
    }

    TreeNode insert(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else if (value <= root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    private boolean search(TreeNode root, int value) {
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

    private TreeNode delete(TreeNode root, int value) {
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
                TreeNode temp = findMin(root.right);
                root.data = temp.data;
                root.right = delete(root.right, temp.data);
            }
        }
        return root;
    }

    static TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    static TreeNode find(TreeNode root, int data) {
        while (root != null) {
            if (data == root.data) {
                return root;
            }
            if (data < root.data) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }
}
