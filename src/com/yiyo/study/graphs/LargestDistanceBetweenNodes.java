package com.yiyo.study.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDistanceBetweenNodes {

    /*
    Find largest distance
    Given an arbitrary unweighted rooted tree which consists of N (2 <= N <= 40000) nodes.
    The goal of the problem is to find largest distance between two nodes in a tree.
    Distance between two nodes is a number of edges on a path between the nodes
    (there will be a unique path between any pair of nodes since it is a tree).
    The nodes will be numbered 0 through N - 1.

    The tree is given as an array P, there is an edge between nodes P[i] and i (0 <= i < N).
    Exactly one of the i’s will have P[i] equal to -1, it will be root node.

     One of the longest path is 1 -> 0 -> 3 -> 4 and its length is 3, thus the answer is 3.
     Note that there are other paths with maximal distance.
     */
    public static void main(String[] args) {
        LargestDistanceBetweenNodes largest = new LargestDistanceBetweenNodes();
        List<Integer> A = Arrays.asList(-1, 0, 0, 0, 3);
        System.out.println(largest.solve(A));
    }

    private int solve(List<Integer> A) {
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < A.size(); ++i) {
            arr.add(new int[2]);
        }
        int maxDistance = 0;
        for (int i = A.size() - 1; i > 0; --i) {
            int element = A.get(i);
            int[] parent = arr.get(element);
            int currentLength = arr.get(i)[0] + 1;

            parent[1] = Math.max(parent[1], currentLength + parent[0]);
            parent[0] = Math.max(parent[0], currentLength);
            maxDistance = Math.max(maxDistance, parent[1]);
        }
        return maxDistance;
    }
}
