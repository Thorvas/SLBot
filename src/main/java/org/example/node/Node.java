package org.example.node;

import lombok.Data;

@Data
public class Node {

    private Node cameFrom;
    private int x;
    private int y;
    private boolean isBlocked;
    private int fCost = Integer.MAX_VALUE;
    private int gCost = Integer.MAX_VALUE;
}
