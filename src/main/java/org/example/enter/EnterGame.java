//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example.enter;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class EnterGame {
    @Autowired
    private WebDriver webDriver;

    public EnterGame() {
    }

    public void enterGame() {

        try {

            this.webDriver.get("https://margonem.pl");
            log.info("Website is now opened.");

            WebElement allow_Cookies_Section = this.webDriver.findElement(By.cssSelector("[aria-label='allow cookies']"));
            WebElement goTo_Login_Section = this.webDriver.findElement(By.linkText("Zaloguj się na Stronie Głównej"));

            log.info("Clicking on Allow Cookies section...");
            allow_Cookies_Section.click();

            log.info("Cookies allowed.");
            log.info("Clicking on Login section...");
            TimeUnit.SECONDS.sleep(1L);

            goTo_Login_Section.click();
            log.info("Login form loaded.");

            WebElement login_Field = this.webDriver.findElement(By.id("login-input"));
            WebElement password_Field = this.webDriver.findElement(By.id("login-password"));
            WebElement login_Button = this.webDriver.findElement(By.id("js-login-btn"));

            log.info("Inserting login...");
            login_Field.sendKeys("kacpicygan123");

            log.info("Login inserted.");
            log.info("Inserting password...");
            password_Field.sendKeys("147425853696C");

            log.info("Password inserted.");
            log.info("Logging into an account...");
            login_Button.click();

            log.info("Logged into account.");
            log.info("Entering game...");
            TimeUnit.SECONDS.sleep(2L);
            WebElement enter_Game = this.webDriver.findElement(By.xpath("//*[contains(@class, 'enter-game')]"));

            enter_Game.click();
            log.info("Successfully entered the game");

            TimeUnit.SECONDS.sleep(3L);

        } catch (Exception var7) {

            log.error(var7.toString());
        }

    }
}
