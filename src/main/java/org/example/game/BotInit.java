//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example.game;

import lombok.extern.slf4j.Slf4j;
import org.example.utility.UtilityMethods;
import org.example.enter.EnterGame;
import org.example.move.MoveModule;
import org.example.node.Node;
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
    private MoveModule moveModule;

    @Autowired
    private EnterGame enterGame;

    public BotInit() {
    }

    public void startBot() {

        try {

            enterGame.enterGame();

            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(60));
            wait.until(ExpectedConditions.attributeContains(By.tagName("body"), "class", "lang-pl"));

            log.info("Bot initialized.");
            JavascriptExecutor js = (JavascriptExecutor) this.webDriver;
            log.info("Moving player to coordinates...");
            TimeUnit.SECONDS.sleep(3L);
            List<Map<String, Object>> npcIds = this.utilityFunction.getAllMobsNames();
            System.out.println(npcIds);

            Node target = new Node();

            target.setX(38);
            target.setY(51);

            moveModule.moveToTarget(target);

            log.info("Event ended.");


        } catch (InterruptedException var3) {

            log.error(var3.toString());
        }
    }
}
