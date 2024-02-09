package org.example.pathfinding;

import org.example.map.MapGrid;
import org.example.node.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Pathfinding {

    private final int G_COST = 10;

    @Autowired
    private MapGrid mapGrid;

    public int heuristics(Node from, Node target) {

        return Math.abs(from.getX() - target.getX()) + Math.abs(from.getY() - target.getY());
    }

    public List<Node> reconstructPath(Node finalNode) {
        Node currentNode = finalNode;
        List<Node> path = new ArrayList<>();

        while (currentNode != null) {
            path.add(currentNode);
            currentNode = currentNode.getCameFrom();
        }

        Collections.reverse(path);
        return path;
    }

    public List<Node> findPathToLocation(Node startNode, Node targetNode) {

        mapGrid.initMap();

        startNode.setGCost(0);
        startNode.setFCost(heuristics(startNode, targetNode));
        PriorityQueue<Node> open = new PriorityQueue<>(Comparator.comparingInt(Node::getFCost));

        HashSet<Node> closed = new HashSet<>();
        open.add(startNode);

        while (!open.isEmpty()) {
            Node current = open.poll();
            closed.add(current);

            if (current.getX() == targetNode.getX() && current.getY() == targetNode.getY()) {

                return this.reconstructPath(current);

            }
            for (Node neighbour : mapGrid.getNeighbours(current)) {
                if (neighbour.isBlocked() || closed.contains(neighbour)) continue;
                int newGCost = current.getGCost() + this.G_COST;
                if (newGCost < neighbour.getGCost() || !open.contains(neighbour)) {
                    neighbour.setCameFrom(current);
                    neighbour.setGCost(newGCost);
                    neighbour.setFCost(newGCost + heuristics(neighbour, targetNode));
                    if (open.contains(neighbour)) open.remove(neighbour);

                    open.add(neighbour);
                }
            }
        }
        return null;
    }

    public List<Node> findPathToMonster(Node startNode, Node targetNode) {

        mapGrid.initMap();

        startNode.setGCost(0);
        startNode.setFCost(heuristics(startNode, targetNode));
        PriorityQueue<Node> open = new PriorityQueue<>(Comparator.comparingInt(Node::getFCost));

        HashSet<Node> closed = new HashSet<>();
        open.add(startNode);

        while (!open.isEmpty()) {
            Node current = open.poll();
            closed.add(current);

            for (Node potentialNode : mapGrid.getAllNeighbours(targetNode)) {
                if (current.getX() == potentialNode.getX() && current.getY() == potentialNode.getY()) {
                    return this.reconstructPath(current);
                }
            }

            for (Node neighbour : mapGrid.getNeighbours(current)) {
                if (neighbour.isBlocked() || closed.contains(neighbour)) continue;
                int newGCost = current.getGCost() + this.G_COST;
                if (newGCost < neighbour.getGCost() || !open.contains(neighbour)) {
                    neighbour.setCameFrom(current);
                    neighbour.setGCost(newGCost);
                    neighbour.setFCost(newGCost + heuristics(neighbour, targetNode));
                    if (open.contains(neighbour)) open.remove(neighbour);

                    open.add(neighbour);
                }
            }
        }
        return null;
    }
}
