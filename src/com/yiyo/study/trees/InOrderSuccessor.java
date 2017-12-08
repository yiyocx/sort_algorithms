package com.yiyo.study.trees;

import static com.yiyo.study.trees.BinarySearchTree.find;
import static com.yiyo.study.trees.BinarySearchTree.findMin;

/**
 * Time complexity: O(h)
 */
public class InOrderSuccessor {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.insert(null, 100);
        bst.insert(root, 98);
        bst.insert(root, 102);
        bst.insert(root, 96);
        bst.insert(root, 97);
        bst.insert(root, 99);

        InOrderSuccessor inOrderSuccessor = new InOrderSuccessor();
        TreeNode node = inOrderSuccessor.getSuccessor(root, 97);
        if (node != null) {
            System.out.println(node.data);
        }
    }

    private TreeNode getSuccessor(TreeNode root, int value) {
        TreeNode current = find(root, value);
        if (current == null) {
            return null;
        }
        // Case 1: Node has right subtree
        if (current.right != null) {
            return findMin(current.right);
        }
        // Case 2: No right subtree
        else {
            TreeNode successor = null;
            TreeNode ancestor = root;
            while (ancestor != current) {
                if (current.data < ancestor.data) {
                    successor = ancestor;
                    ancestor = ancestor.left;
                } else {
                    ancestor = ancestor.right;
                }
            }
            return successor;
        }
    }
}
