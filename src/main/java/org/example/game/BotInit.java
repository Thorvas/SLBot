//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example.game;

import lombok.extern.slf4j.Slf4j;
import org.example.Utility.UtilityFunction;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class BotInit {
    @Autowired
    private WebDriver webDriver;
    @Autowired
    private UtilityFunction utilityFunction;

    public BotInit() {
    }

    public void startBot() {
        try {
            TimeUnit.SECONDS.sleep(2L);
            log.info("Bot initialized.");
            JavascriptExecutor js = (JavascriptExecutor) this.webDriver;
            log.info("Moving player to coordinates...");
            TimeUnit.SECONDS.sleep(3L);
            List<Map<String, Object>> npcIds = this.utilityFunction.getAllMobsNames();
            System.out.println(npcIds);
        } catch (Exception var3) {
            log.error(var3.toString());
        }

    }
}
