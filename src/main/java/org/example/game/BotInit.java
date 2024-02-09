//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example.game;

import lombok.extern.slf4j.Slf4j;
import org.example.Utility.UtilityMethods;
import org.example.map.MapGrid;
import org.example.node.Node;
import org.example.pathfinding.Pathfinding;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class BotInit {
    @Autowired
    private WebDriver webDriver;
    @Autowired
    private UtilityMethods utilityFunction;

    @Autowired
    private MapGrid mapGrid;

    @Autowired
    private Pathfinding aStar;

    public BotInit() {
    }

    public void startBot() {

        try {

            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.attributeContains(By.tagName("body"), "class", "lang-pl"));

            log.info("Bot initialized.");
            JavascriptExecutor js = (JavascriptExecutor) this.webDriver;
            log.info("Moving player to coordinates...");
            TimeUnit.SECONDS.sleep(3L);
            List<Map<String, Object>> npcIds = this.utilityFunction.getAllMobsNames();
            System.out.println(npcIds);

            Node begin = new Node();
            Node target = new Node();

            begin.setX(44);
            begin.setY(56);
            begin.setBlocked(false);

            target.setX(42);
            target.setY(50);
            target.setBlocked(false);

            System.out.println("RECONSTRUCTED PATH:");
            System.out.println(aStar.findPath(begin, target));

//            utilityFunction.movePlayerUp(10);
//            utilityFunction.movePlayerRight(10);
//            utilityFunction.movePlayerLeft(10);
//            utilityFunction.movePlayerDown(10);

            log.info("Event ended.");

            webDriver.quit();
        } catch (InterruptedException var3) {

            log.error(var3.toString());
        }
    }
}
