package com.preetham.WeightedGraph;

import java.util.*;

public class WeightedGraph {

    private class Edge {
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + "->" + to;
        }
    }

    private class Node {
        private String label;
        private List<Edge> edges = new ArrayList<>();

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }

        public void addEdge(Node to, int weight) {
            edges.add(new Edge(this, to, weight));
        }

        public List<Edge> getEdges() {
            return edges;
        }
    }


    private Map<String, Node> nodes = new HashMap<>();
//    private Map<Node, List<Edge>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        var node = new Node(label);

        nodes.putIfAbsent(label, node);
    }

    public void addEdge(String from, String to, int weight) {
        var fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalStateException();

        var toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalStateException();

        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);

    }

    public void print() {
        for (var node : nodes.values()) {
            var edges = node.getEdges();
            if (!edges.isEmpty())
                System.out.println(node + " is connected to " + edges);
        }
    }

    private class NodeEntry { //this class is for priority queue
        private Node node;
        private int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    public int getShortestDistance(String from, String to) {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);

        Map<Node, Integer> distances = new HashMap<>();
        for (var node : nodes.values())
            distances.put(node, Integer.MAX_VALUE);
        distances.replace(fromNode, 0);

        Set<Node> visited = new HashSet<>();

        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));
        queue.add(new NodeEntry(fromNode, 0));

        while (!queue.isEmpty()) { //Breadth-First traversal
            var current = queue.remove().node;
            visited.add(current);

            for (var edge : current.getEdges()) {
                if (visited.contains(edge.to))
                    continue;

                var newDistance = distances.get(current) + edge.weight;
                if (newDistance < distances.get(edge.to)) { //edge.to is neighbour
                    distances.replace(edge.to, newDistance);
                    queue.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }

        return distances.get(toNode);
    }

    public void printShortestDistances(String from){
        var source = nodes.get(from).label;
        for (var node: nodes.values()){
            var dist = getShortestDistance(from, node.label);
            System.out.println("the distance from "+from+" to "+node.label+" is "+dist );
        }
    }

    public String getMaxDistancesWithEndNode(String from){
        List<Integer> list = new ArrayList<>();
        List<String> ch = new ArrayList<>();
        int max = -1;

        for (var node: nodes.values()){
            list.add(getShortestDistance(from, node.label)) ;
            ch.add(node.label);
        }

        int index = 0;
        for (var item: list){
            if (item > max) {
                max = item;
                index = list.indexOf(max);
            }
        }
        String maxDistNode = ch.get(index);

//        System.out.println(from+"->"+ maxDistNode+"="+max);

        return maxDistNode;

    }

    public int getMaxDistances(String from){
        List<Integer> list = new ArrayList<>();
        int max = -1;

        for (var node: nodes.values()){
            list.add(getShortestDistance(from, node.label)) ;
        }
        for (var item: list){
            if (item > max)
                max = item;
        }

        return max;
    }

    public Path getShortestPath(String from, String to) {
        var fromNode = nodes.get(from);
        if (fromNode == null)
            throw new IllegalStateException();

        var toNode = nodes.get(to);
        if (toNode == null)
            throw new IllegalStateException();

        Map<Node, Integer> distances = new HashMap<>();
        for (var node : nodes.values())
            distances.put(node, Integer.MAX_VALUE);
        distances.replace(fromNode, 0); //distance from fromNode to itself is 0

        Map<Node, Node> previousNodes = new HashMap<>();

        Set<Node> visited = new HashSet<>();

        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority)); //order them based on priority
        queue.add(new NodeEntry(fromNode, 0)); //priority of starting node is 0

        while (!queue.isEmpty()) {
            var current = queue.remove().node; //we use .node coz without that it will return nodeEntry object
            visited.add(current);

            for (var edge : current.getEdges()) {
                if (visited.contains(edge.to)) //destination edge
                    continue;

                var newDistance = distances.get(current) + edge.weight; //formula , distances.get(current) -> distance from starting node to current node
                if (newDistance < distances.get(edge.to)) { //edge.to -> neighbour
                    distances.replace(edge.to, newDistance);
                    previousNodes.put(edge.to, current);
                    queue.add(new NodeEntry(edge.to, newDistance));
                }
            }
        }
        return buildPath(previousNodes, toNode); //line 102
    }

    private Path buildPath(Map<Node, Node> previousNodes, Node toNode) {
        Stack<Node> stack = new Stack<>();
        stack.push(toNode); //initially pushing destination node to stack
        var previous = previousNodes.get(toNode); //getting the prev node
        while (previous != null) {
            stack.push(previous);
            previous = previousNodes.get(previous); //recursively pushing prev nodes to stack
        }

        var path = new Path();
        while (!stack.isEmpty())
            path.add(stack.pop().label);

        return path;
    }

    public boolean hasCycle() { //we need to do dfs
        Set<Node> visited = new HashSet<>();
        for (var node : nodes.values()) {
            if (!visited.contains(node) && hasCycle(node, null, visited)) //parent for initial node is null
                return true;
        }

        return false;
    }

    private boolean hasCycle(Node node, Node parent, Set<Node> visited) {
        visited.add(node);

        for (var edge : node.getEdges()) { //looking for neighbours
            if (edge.to == parent) //means this is where we came from
                continue;

            if (visited.contains(edge.to)) //indicates cycle
                return true;

            if (hasCycle(edge.to, node, visited))
                return true;
        }

        return false;
    }

    public WeightedGraph getMinimumSpanningTree() {
        var tree = new WeightedGraph();

        if (nodes.isEmpty())
            return tree;

        PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        var startNode = nodes.values().iterator().next();
        edges.addAll(startNode.getEdges());
        tree.addNode(startNode.label);

        if (edges.isEmpty())
            return tree;

        while (tree.nodes.size() < nodes.size()) {
            var minEdge = edges.remove(); //edge with min weight from the queue
            var nextNode = minEdge.to;

            if (tree.containsNode(nextNode.label))
                continue;

            tree.addNode(nextNode.label);
            tree.addEdge(minEdge.from.label, nextNode.label, minEdge.weight);

            for (var edge : nextNode.getEdges())
                if (!tree.containsNode(edge.to.label)) //nodes we have not visited so far
                    edges.add(edge);
        }

        return tree;
    }

    public boolean containsNode(String label) {
        return nodes.containsKey(label);
    }

}

/*
        var graph = new WeightedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B", 1);
        graph.addEdge("B", "C", 2);
        graph.addEdge("A", "C", 4);
        graph.printShortestDistances("A");
//      graph.addEdge("A", "C", 10);
//        var dist = graph.getShortestDistance("A", "C");
//        System.out.println(dist);
//        var path = graph.getShortestPath("A", "C");
//        System.out.println(path);
//        var res = graph.hasCycle();
//        System.out.println(res);
 */

/*
        var graph = new WeightedGraph();
        int grph[][] = new int[][]{
                {-1, 3, -1, -1, -1, -1, -1, 7, -1},
                {3, -1, 7, -1, -1, -1, -1, 10, 4},
                {-1, 7, -1, 6, -1, 2, -1, -1, 1},
                {-1, -1, 6, -1, 8, 13, -1, -1, 3},
                {-1, -1, -1, 8, -1, 9, -1, -1, -1},
                {-1, -1, 2, 13, 9, -1, 4, -1, 5},
                {-1, -1, -1, -1, -1, 4, -1, 2, 5},
                {7, 10, -1, -1, -1, -1, 2, -1, 6},
                {-1, 4, 1, 3, -1, 5, 5, 6, -1}};

        // creating an object of the class DijkstraExample
        DijkstraAlgorithm obj = new DijkstraAlgorithm();
        obj.dijkstra(grph, 0);
 */

/*
        var graph = new WeightedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "B", 3);
        graph.addEdge("B", "D", 4);
        graph.addEdge("C", "D", 5);
        graph.addEdge("A", "C", 1);
        graph.addEdge("B", "C", 2);
        var tree = graph.getMinimumSpanningTree();
        tree.print();
 */



/*
        var graph = new WeightedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("A", "B", 1);
        graph.addEdge("B", "C", 2);
//      graph.addEdge("A", "C", 10);
        var path = graph.getShortestPath("A", "C");
        System.out.println(path);
        var res = graph.hasCycle();
        System.out.println(res);
 */

/*
        int graph[][] = new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, 0);
 */