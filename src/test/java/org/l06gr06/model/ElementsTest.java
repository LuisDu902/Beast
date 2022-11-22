package org.l06gr06.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.model.game.elements.Hero;
import org.l06gr06.model.game.elements.Monster;
import org.l06gr06.model.game.elements.Shield;

public class ElementsTest {

    @Test
    public void IncreaseEnergy(){
        Hero hero = new Hero(20,20);
        hero.increaseEnergy();
        Assertions.assertEquals(6, hero.getEnergy());
    }

    @Test
    public void Shield(){
        Shield shield = new Shield(20,20);
        shield.decreaseTimer();
        Assertions.assertEquals(9, shield.getTimer());
    }

    @Test
    public void Monster(){
        Monster monster = new Monster(20,20);
        monster.evolve();
        Assertions.assertEquals(1, monster.getPhase());
    }

    @Test
    public void DecreaseEnergy(){
        Hero hero = new Hero(20,20);
        hero.decreaseEnergy();
        Assertions.assertEquals(4, hero.getEnergy());
    }
}
