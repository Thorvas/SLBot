//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example.Utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;
import org.example.node.Node;
import org.example.player.Player;
import org.example.player.UtilityPlayer;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UtilityMethods {
    @Autowired
    private WebDriver webDriver;

    @Autowired
    private UtilityPlayer utilityPlayer;

    public List<Map<String, Object>> getAllMobsNames() {
        JavascriptExecutor js = (JavascriptExecutor)this.webDriver;
        return (List<Map<String, Object>>) js.executeScript("return Object.entries(Engine.npcs.check()).map(([id, npc]) => ({id: id, name: npc.d.nick, x: npc.d.x, y: npc.d.y}));", new Object[0]);
    }

    public void printPlayerCoords() {
        JavascriptExecutor js = (JavascriptExecutor)this.webDriver;

        Player player = this.utilityPlayer.updatePlayer();

        log.info("Coordinate x: "+player.getX()+", Coordinate y:"+player.getY());
    }

    public List<Node> convertToGrid() {

        JavascriptExecutor js = (JavascriptExecutor) this.webDriver;

        List<Map<String, Object>> nodes = (List<Map<String, Object>>) js.executeScript("return Engine.hero.getHeroNode().chunk.map.nodes.map(node => ({x: node.x, y: node.y, isBlocked: Engine.map.col.check(node.x, node.y)}));");

        List<Node> readyNodes = new ArrayList<>();
        for (Map<String, Object> obj : nodes) {

            Node node = new Node();

            Long x = (Long) obj.get("x");
            Long y = (Long) obj.get("y");
            Long isBlocked = (Long) obj.get("isBlocked");

            node.setX(x.intValue());
            node.setY(y.intValue());
            node.setBlocked(isBlocked != 0);

            readyNodes.add(node);
        }

        return readyNodes;
    }


}
