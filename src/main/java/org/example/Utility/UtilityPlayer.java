package org.example.Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UtilityPlayer {

    @Autowired
    private WebDriver webDriver;

    @Autowired
    private Player player;

    public Player updatePlayer() {

        JavascriptExecutor js = (JavascriptExecutor) this.webDriver;

        this.player.setName((String) js.executeScript("return Engine.hero.d.nick;"));
        this.player.setHp((Long) js.executeScript("return Engine.hero.d.warrior_stats.hp;"));
        this.player.setX((Long) js.executeScript("return Engine.hero.d.x;"));
        this.player.setY((Long) js.executeScript("return Engine.hero.d.y;"));
        this.player.setLvl((Long) js.executeScript("return Engine.hero.d.lvl;"));

        return this.player;
    }
}
