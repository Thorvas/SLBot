package org.example.player;

import lombok.extern.slf4j.Slf4j;
import org.example.utility.UtilityMethods;
import org.example.node.Node;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
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


    public void movePlayerUp(Integer distance) {
        try {

            Actions actions = new Actions(webDriver);

            for (int i = 0; i < distance; i++) {

                log.info("Moving up..");
                actions.keyDown(Keys.ARROW_UP).perform();
                TimeUnit.MILLISECONDS.sleep(195);
                actions.keyUp(Keys.ARROW_UP).perform();

//                utils.printPlayerCoords();
            }

        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    public void movePlayerDown(Integer distance) {
        try {

            Actions actions = new Actions(webDriver);

            for (int i = 0; i < distance; i++) {

                log.info("Moving down..");
                actions.keyDown(Keys.ARROW_DOWN).perform();
                TimeUnit.MILLISECONDS.sleep(195);
                actions.keyUp(Keys.ARROW_DOWN).perform();

//                utils.printPlayerCoords();
            }

        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    public void movePlayerRight(Integer distance) {
        try {

            Actions actions = new Actions(webDriver);

            for (int i = 0; i < distance; i++) {

                log.info("Moving right..");
                actions.keyDown(Keys.ARROW_RIGHT).perform();
                TimeUnit.MILLISECONDS.sleep(195);
                actions.keyUp(Keys.ARROW_RIGHT).perform();

//                utils.printPlayerCoords();
            }

        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    public void movePlayerLeft(Integer distance) {
        try {

            Actions actions = new Actions(webDriver);

            for (int i = 0; i < distance; i++) {

                log.info("Moving left..");
                actions.keyDown(Keys.ARROW_LEFT).perform();
                TimeUnit.MILLISECONDS.sleep(195);
                actions.keyUp(Keys.ARROW_LEFT).perform();

//                utils.printPlayerCoords();
            }

        } catch (Exception e) {

            log.error(e.toString());
        }
    }

    //TODO: Delete legacy method
//    public void moveToNode(Node node) {
//
//        this.player = updatePlayer();
//
//        if (this.player != null) {
//            if (node.getY() == player.getY() - 1) {
//                movePlayerUp(1);
//            } else if (node.getY() == player.getY() + 1) {
//                movePlayerDown(1);
//            } else if (node.getX() == player.getX() - 1) {
//                movePlayerLeft(1);
//            } else if (node.getX() == player.getX() + 1) {
//                movePlayerRight(1);
//            }
//
//        }
//    }

    public void moveToNode(Node sourceNode, Node targetNode) {

        if (this.player != null) {
            if (targetNode.getY() == sourceNode.getY() - 1) {
                movePlayerUp(1);
            } else if (targetNode.getY() == sourceNode.getY() + 1) {
                movePlayerDown(1);
            } else if (targetNode.getX() == sourceNode.getX() - 1) {
                movePlayerLeft(1);
            } else if (targetNode.getX() == sourceNode.getX() + 1) {
                movePlayerRight(1);
            }

        }
    }
}
