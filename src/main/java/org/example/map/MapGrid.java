package org.example.map;

import org.example.Utility.UtilityMethods;
import org.example.node.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapGrid {

    @Autowired
    private UtilityMethods mapUtils;

    private List<Node> nodesToSearch = null;

    public void initMap() {
        this.nodesToSearch = mapUtils.convertToGrid();
    }

    public Node getNode(int x, int y) {

        Node targetNode = null;

        for (Node node : nodesToSearch) {

            if (node.getX() == x && node.getY() == y) {
                targetNode = node;
            }
        }

        return targetNode;
    }

    public List<Node> getNeighbours(Node node) {

        List<Node> neighbours = new ArrayList<>();

        int[] directions = {-1, 0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {

            int newX = node.getX() + directions[i];
            int newY = node.getY() + directions[i + 1];

            Node neighbour = this.getNode(newX, newY);

            if (neighbour != null && !neighbour.isBlocked()) {

                neighbours.add(neighbour);
            }
        }

        return neighbours;
    }
}
