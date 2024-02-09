package org.example.player;

import org.example.Utility.UtilityMethods;
import org.example.node.Node;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UtilityPlayer {

    @Autowired
    private WebDriver webDriver;

    @Autowired
    private UtilityMethods utils;

    private Player player;

    public Player updatePlayer() {

        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        this.player = new Player();

        player.setName((String) js.executeScript("return Engine.hero.d.nick;"));
        player.setHp((Long) js.executeScript("return Engine.hero.d.warrior_stats.hp;"));
        player.setX((Long) js.executeScript("return Engine.hero.d.x;"));
        player.setY((Long) js.executeScript("return Engine.hero.d.y;"));
        player.setLvl((Long) js.executeScript("return Engine.hero.d.lvl;"));

        return player;
    }

    public void moveThroughPath(List<Node> nodes) {

        this.player = updatePlayer();

        if (this.player != null) {

            for (int i = 1; i < nodes.size(); i++) {
                if (nodes.get(i).getY() < player.getY()) {
                    utils.movePlayerUp(1);
                }
                else if (nodes.get(i).getY() > player.getY()) {
                    utils.movePlayerDown(1);
                }
                else if (nodes.get(i).getX() < player.getX()) {
                    utils.movePlayerLeft(1);
                }
                else if (nodes.get(i).getX() > player.getX()) {
                    utils.movePlayerRight(1);
                }
                else {
                    System.out.println("Road reached!");
                }
            }

        }
    }
}
