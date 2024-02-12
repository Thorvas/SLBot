//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example.enter;

import lombok.extern.slf4j.Slf4j;
import org.example.website.WebsiteInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class EnterGame {

    @Autowired
    private WebsiteInit websiteInit;

    public void enterGame() {
        try {

            websiteInit.openWebsite();
            websiteInit.allowCookies();
            websiteInit.openLogin();
            websiteInit.insertLogin();
            websiteInit.insertPassword();
            websiteInit.confirmForm();

            TimeUnit.SECONDS.sleep(3L);

        } catch (Exception var7) {
            log.error(var7.toString());
        }

    }
}
