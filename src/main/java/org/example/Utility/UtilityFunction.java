//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example.Utility;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UtilityFunction {
    @Autowired
    private WebDriver webDriver;

    public List<Map<String, Object>> getAllMobsNames() {
        JavascriptExecutor js = (JavascriptExecutor)this.webDriver;
        return (List<Map<String, Object>>) (List)js.executeScript("return Object.entries(Engine.npcs.check()).map(([id, npc]) => ({id: id, name: npc.d.nick, x: npc.d.x, y: npc.d.y}));", new Object[0]);
    }
}
