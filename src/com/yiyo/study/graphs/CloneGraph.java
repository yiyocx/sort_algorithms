package com.yiyo.study.graphs;

import java.util.*;

public class CloneGraph {

    /*
    Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
     */
    public static void main(String[] args) {
        CloneGraph graph = new CloneGraph();

        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
        UndirectedGraphNode node3 = new UndirectedGraphNode(3);
        UndirectedGraphNode node4 = new UndirectedGraphNode(4);
        Vector<UndirectedGraphNode> v = new Vector<>();
        v.add(node2);
        v.add(node4);
        node1.neighbors = v;
        v = new Vector<>();
        v.add(node1);
        v.add(node3);
        node2.neighbors = v;
        v = new Vector<>();
        v.add(node2);
        v.add(node4);
        node3.neighbors = v;
        v = new Vector<>();
        v.add(node3);
        v.add(node1);
        node4.neighbors = v;

        System.out.println(graph.cloneGraph(node1));
    }

    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        map.put(node, new UndirectedGraphNode(node.label));
        queue.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode current = queue.poll();
            UndirectedGraphNode currentCloned = map.get(current);

            if (current.neighbors != null) {
                for (UndirectedGraphNode neighbor : current.neighbors) {
                    UndirectedGraphNode clonedNeighbor = map.get(neighbor);
                    if (clonedNeighbor == null) {
                        clonedNeighbor = new UndirectedGraphNode(neighbor.label);
                        map.put(neighbor, clonedNeighbor);
                        queue.add(neighbor);
                    }
                    currentCloned.neighbors.add(clonedNeighbor);
                }
            }
        }
        return map.get(node);
    }
}
