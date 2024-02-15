package org.example.website;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class WebsiteInit {

    @Autowired
    private WebDriver webDriver;

    @Value("${provided.login}")
    private String login;

    @Value("${provided.password")
    private String password;

    public void openWebsite() {

        this.webDriver.get("https://margonem.pl");
        log.info("Website is now opened.");
    }

    public void allowCookies() {

        WebElement allow_Cookies_Section = this.webDriver.findElement(By.cssSelector("[aria-label='allow cookies']"));
        log.info("Clicking on Allow Cookies section...");
        allow_Cookies_Section.click();
        log.info("Cookies allowed.");
    }

    public void openLogin() {
        try {
            WebElement goTo_Login_Section = this.webDriver.findElement(By.linkText("Zaloguj się na Stronie Głównej"));
            log.info("Clicking on Login section...");
            TimeUnit.SECONDS.sleep(1L);
            goTo_Login_Section.click();
            log.info("Login form loaded.");
        } catch (InterruptedException exc) {
            log.error(exc.toString());
        }
    }

    public void insertLogin() {
        WebElement login_Field = this.webDriver.findElement(By.id("login-input"));
        log.info("Inserting login...");
        login_Field.sendKeys(login);
        log.info("Login inserted.");
    }

    public void insertPassword() {
        WebElement password_Field = this.webDriver.findElement(By.id("login-password"));
        log.info("Inserting password...");
        password_Field.sendKeys("147425853696C");
        log.info("Password inserted.");
    }

    public void confirmForm() {
        try {
            WebElement login_Button = this.webDriver.findElement(By.id("js-login-btn"));
            log.info("Logging into an account...");
            login_Button.click();

            log.info("Logged into account.");
            log.info("Entering game...");
            TimeUnit.SECONDS.sleep(2L);
            WebElement enter_Game = this.webDriver.findElement(By.xpath("//*[contains(@class, 'enter-game')]"));

            enter_Game.click();
            log.info("Successfully entered the game");
        } catch (InterruptedException exc) {
            log.error(exc.toString());
        }
    }
}
