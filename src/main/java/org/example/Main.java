//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example;

import org.example.game.BotInit;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        BotInit botInit = context.getBean(BotInit.class);

        botInit.startBot();
    }
}
