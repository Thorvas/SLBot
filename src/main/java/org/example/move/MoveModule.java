package org.example.move;

import org.example.map.MapGrid;
import org.example.node.Node;
import org.example.pathfinding.Pathfinding;
import org.example.player.UtilityPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MoveModule {

    @Autowired
    private MapGrid mapGrid;

    @Autowired
    private Pathfinding pathFinder;

    @Autowired
    private UtilityPlayer playerUtils;

    public void moveToTarget(Node target) {

        List<Node> path = pathFinder.findPathToLocation(playerUtils.updatePlayer().getNode(), target);

        for (int i = 0; i < path.size() - 1; i++) {
            playerUtils.moveToNode(path.get(i), path.get(i+1));
        }


        System.out.println(playerUtils.updatePlayer().getX() + ", " + playerUtils.updatePlayer().getY());
        System.out.println(target.getX() + ", " + target.getY());
    }
}
