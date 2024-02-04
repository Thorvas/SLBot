//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example;

import org.example.Utility.Player;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
        basePackages = {"org.example"}
)
public class BeanConfig {
    public BeanConfig() {
    }

    @Bean
    public Player player() {

        Player player = new Player();

        player.setHp(0L);
        player.setY(0L);
        player.setX(0L);
        player.setName("Blank");
        player.setLvl(0L);

        return player;
    }

    @Bean
    public WebDriver webDriver() {
        WebDriver driver = new ChromeDriver(chromeOptions());
        return driver;
    }

    @Bean
    public ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--start-maximized");
        return options;
    }
}
