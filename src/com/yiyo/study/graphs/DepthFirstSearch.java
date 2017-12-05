package com.yiyo.study.graphs;

import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstSearch {

    public static void main(String[] args) {
        Node<String> A = new Node<>("A");
        Node<String> B = new Node<>("B");
        Node<String> C = new Node<>("C");
        Node<String> D = new Node<>("D");
        Node<String> E = new Node<>("E");
        Node<String> F = new Node<>("F");

        A.addNeighbour(B);
        A.addNeighbour(C);
        B.addNeighbour(C);
        B.addNeighbour(D);
        D.addNeighbour(E);
        C.addNeighbour(D);
        E.addNeighbour(A);
        E.addNeighbour(B);
        E.addNeighbour(F);

        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.depthFirstSearchTraversal(A);
    }

    private void depthFirstSearchTraversal(Node startNode) {
        Stack<Node> stack = new Stack<>();
        stack.add(startNode);
        startNode.setVisited(true);

        while (!stack.isEmpty()) {
            Node element = stack.pop();
            System.out.print(element.getData() + " ");

            LinkedList<Node> neighbours = element.getNeighbours();
            for (Node neighbour : neighbours) {
                if (!neighbour.getVisited()) {
                    neighbour.setVisited(true);
                    stack.add(neighbour);
                }
            }
        }
    }
}
