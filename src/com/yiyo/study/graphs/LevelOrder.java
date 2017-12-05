package com.yiyo.study.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

    /*
    Given a binary tree, return the level order traversal of its nodes’ values. (ie, from left to right, level by level)
     */

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        a.left = new TreeNode(9);
        TreeNode b = new TreeNode(20);
        b.left = new TreeNode(15);
        b.right = new TreeNode(7);
        a.right = b;

        LevelOrder levelOrder = new LevelOrder();
        System.out.println(levelOrder.levelOrder(a));
    }

    private ArrayList<ArrayList<Integer>> levelOrder(TreeNode a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(a);

        while (!queue.isEmpty()) {
            int n = queue.size();
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode element = queue.poll();
                list.add(element.val);

                if (element.left != null) {
                    queue.add(element.left);
                }

                if (element.right != null) {
                    queue.add(element.right);
                }
            }
            result.add(list);
        }
        return result;
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
