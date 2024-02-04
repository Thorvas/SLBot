//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example.Utility;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;
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

        Player player = utilityPlayer.updatePlayer(webDriver);

        log.info("Coordinate x: "+player.getX()+", Coordinate y:"+player.getY());
    }

    public void movePlayerUp(Integer distance) {
        try {
            Actions actions = new Actions(webDriver);

            for (int i = 0; i < distance; i++) {

                log.info("Moving up..");
                actions.keyDown(Keys.ARROW_UP).perform();
                TimeUnit.MILLISECONDS.sleep(175);
                actions.keyUp(Keys.ARROW_UP).perform();

                this.printPlayerCoords();
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
                TimeUnit.MILLISECONDS.sleep(175);
                actions.keyUp(Keys.ARROW_DOWN).perform();

                this.printPlayerCoords();
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
                TimeUnit.MILLISECONDS.sleep(175);
                actions.keyUp(Keys.ARROW_RIGHT).perform();

                this.printPlayerCoords();
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
                TimeUnit.MILLISECONDS.sleep(175);
                actions.keyUp(Keys.ARROW_LEFT).perform();

                this.printPlayerCoords();
            }

        } catch (Exception e) {
            log.error(e.toString());
        }
    }
}
