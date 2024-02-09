package org.example.node;

import lombok.Data;

import java.util.List;

@Data
public class Node {

    private Node parent;
    private int x;
    private int y;
    private boolean isBlocked;
}
