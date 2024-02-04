package org.example.player;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
public class UtilityPlayer {

    public static Player updatePlayer(WebDriver webDriver) {

        Player player = new Player();

        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        player.setName((String) js.executeScript("return Engine.hero.d.nick;"));
        player.setHp((Long) js.executeScript("return Engine.hero.d.warrior_stats.hp;"));
        player.setX((Long) js.executeScript("return Engine.hero.d.x;"));
        player.setY((Long) js.executeScript("return Engine.hero.d.y;"));
        player.setLvl((Long) js.executeScript("return Engine.hero.d.lvl;"));

        return player;
    }
}
