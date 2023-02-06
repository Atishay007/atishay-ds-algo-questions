package com.graphs;

import java.util.*;

//Using BFS(Breadth First Search/InOrder Traversal: Using Queue: Check for neighbors first)
public class FindPathBetween1And5 {

    public static void main(String[] args) {
        int A = 5;
        int[][] arr = {{1, 2}, {4, 1}, {2, 4}, {3, 4}, {5, 2}, {1, 3}};
        //int[][] arr = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        System.out.println(solve(A, arr));
    }

    private static int solve(int A, int[][] B) {

        Map<Node, List<Node>> map = new HashMap<>();

        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[i].length - 1; j++) {
                Node node = new Node(B[i][j]);
                List<Node> neighbors = map.get(node);
                if (neighbors == null) {
                    neighbors = new ArrayList<>();
                }
                neighbors.add(new Node(B[i][j + 1]));
                map.put(node, neighbors);
            }
        }

        //Using BFS now, starterNode is from where we have to search the path.
        Node starterNode = new Node(1);
        LinkedList<Node> queue = new LinkedList<>();

        queue.push(starterNode);

        while (!queue.isEmpty()) {
            Node node = queue.pop();
            if (!node.visited) {
                node.visited = true;

                if (node.val == A) {
                    return 1;
                }

                List<Node> neighbors = map.get(node);
                if (neighbors != null) {
                    for (Node neighbor : neighbors) {
                        if (neighbor.val == 5) {
                            neighbor.visited = true;
                            return 1;
                        }
                        queue.push(neighbor);
                    }
                }
            }
        }
        return 0;
    }


    private static class Node {
        int val;
        List<Node> neighbors = new ArrayList<>();
        boolean visited;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }

            if (obj instanceof Node) {
                return ((Node) obj).val == this.val;
            }

            return false;

        }

        @Override
        public int hashCode() {
            return this.val * 31;
        }
    }
}
