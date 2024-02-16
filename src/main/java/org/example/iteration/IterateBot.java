package org.example.iteration;

import lombok.extern.slf4j.Slf4j;
import org.example.monster.Monster;
import org.example.move.MoveModule;
import org.example.utility.UtilityMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class IterateBot {

    @Autowired
    private UtilityMethods utilityFunction;

    @Autowired
    private MoveModule moveModule;

    public void processWalkAndAttack() {

        try {

            List<Monster> monsters = utilityFunction.convertToMonsters();
            Monster closestMonster = utilityFunction.findClosestMonster(monsters);
            System.out.println(closestMonster.getName());
            System.out.println(closestMonster.getPosition().getX() + ", " + closestMonster.getPosition().getY());
            moveModule.moveToTarget(closestMonster.getPosition());
            utilityFunction.attackMob();

        } catch (Exception e) {

            log.error(e.toString());
        }

    }
}
