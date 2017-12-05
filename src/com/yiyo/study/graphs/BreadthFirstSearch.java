package com.yiyo.study.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

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

        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.breadthFirstSearchTraversal(A);
    }

    private void breadthFirstSearchTraversal(Node startNode) {
        Queue<Node> queue = new LinkedList<>();

        startNode.setVisited(true);
        queue.add(startNode);

        while (!queue.isEmpty()) {
            Node element = queue.poll();
            System.out.print(element.getData() + " ");

            LinkedList<Node> neighbours = element.getNeighbours();
            for (Node neighbour : neighbours) {
                if (!neighbour.getVisited()) {
                    neighbour.setVisited(true);
                    queue.add(neighbour);
                }
            }
        }
    }
}
