package org.example.player;

import lombok.Data;
import org.example.node.Node;

@Data
public class Player {

    private String name;
    private Long hp;
    private Long lvl;
    private Long x;
    private Long y;

    public Node getNode() {

        Node node = new Node();

        node.setX(this.getX().intValue());
        node.setY(this.getY().intValue());
        node.setBlocked(false);

        return node;
    }
}
