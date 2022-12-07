package org.l06gr06.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.model.game.elements.*;

public class ElementsTest {
    @Test
    public void Element(){
        Element element = new Element(20,20);
        element.setPosition(new Position(21,20));
        Assertions.assertEquals(new Position(21,20), element.getPosition());
    }
    @Test
    public void IncreaseLife(){
        Player player = new Player(20,20);
        player.increaseLife();
        Assertions.assertEquals(6, player.getLife());
    }
    @Test
    public void DecreaseLife(){
        Player player = new Player(20,20);
        player.decreaseLife();
        Assertions.assertEquals(4, player.getLife());
    }
    @Test
    public void ImmortalPlayer(){
        Player player = new Player(20,20);
        player.becomeImmortal();
        Assertions.assertEquals(1, player.getPhase());
    }
    @Test
    public void NormalPlayer(){
        Player player = new Player(20,20);
        player.becomeImmortal();
        player.backToNormal();
        Assertions.assertEquals(0, player.getPhase());
    }

    @Test
    public void Shield(){
        Shield shield = new Shield(20,20);
        shield.decreaseTimer();
        Assertions.assertEquals(9, shield.getTimer());
    }

    @Test
    public void Beast(){
        Beast beast = new Beast(20,20,1);
        beast.evolve();
        Assertions.assertEquals(2, beast.getPhase());
    }



}
