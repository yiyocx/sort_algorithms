package com.yiyo.study.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 3);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(4, 5);

        graph.breadthFirstSearchTraversal(0);
    }

    private int verticesNum;
    private LinkedList<Integer>[] adj;

    Graph(int verticesNum) {
        this.verticesNum = verticesNum;
        adj = new LinkedList[verticesNum];

        for (int i = 0; i < verticesNum; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    private void addEdge(int startVertex, int endVertex) {
        adj[startVertex].add(endVertex);
    }

    private void breadthFirstSearchTraversal(int startVertex) {
        boolean[] visited = new boolean[verticesNum];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            System.out.print(vertex + " ");

            for (Integer neighbour : adj[vertex]) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
    }

    private void depthFirstSearchTraversal() {

    }
}
