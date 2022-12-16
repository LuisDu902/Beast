package org.l06gr06.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.l06gr06.model.game.elements.*;

public class ElementsTest {
    @Test
    public void Element(){
        Element element = new Element(new Position(20,20));
        element.setPosition(new Position(21,20));
        Assertions.assertEquals(new Position(21,20), element.getPosition());
    }
    @Test
    public void IncreaseLife(){
        Player player = new Player(new Position(20,20));
        player.increaseLife();
        Assertions.assertEquals(6, player.getLife());
    }
    @Test
    public void DecreaseLife(){
        Player player = new Player(new Position(20,20));
        player.decreaseLife();
        Assertions.assertEquals(4, player.getLife());
    }
    @Test
    public void ImmortalPlayer(){
        Player player = new Player(new Position(20,20));
        player.becomeImmortal();
        player.setImmortalTime(10);
        Assertions.assertEquals(1, player.getPhase());
        Assertions.assertEquals(10, player.getImmortalTime());
    }
    @Test
    public void NormalPlayer(){
        Player player = new Player(new Position(20,20));
        player.becomeImmortal();
        player.backToNormal();
        Assertions.assertEquals(0, player.getPhase());
    }

    @Test
    public void Beast(){
        Beast beast = new Beast(new Position(20,20),1);
        beast.evolve();
        Assertions.assertEquals(2, beast.getPhase());
    }

    @Test
    public void StrongerBeast(){
        Beast beast = new Beast(new Position(20,20),2);
        beast.evolve();
        Assertions.assertEquals(2, beast.getPhase());
    }

    @Test
    public void PowerUpDuration(){
        PowerUp powerUp = new PowerUp(new Position(20,20));
        Assertions.assertEquals(10,powerUp.getDuration());
    }

    @Test
    public void PowerUpCreationTime(){
        long time = System.currentTimeMillis();
        PowerUp powerUp = new PowerUp(new Position(20,20));
        Assertions.assertEquals(time,powerUp.getCreationTime());
    }

    @Test
    public void equal(){
        Element element = new Element(new Position(20,20));
        Assertions.assertEquals(new Element(new Position(20,20)),element);
    }

    @Test
    public void notEqual(){
        Element element = new Element(new Position(20,20));
        Element element1 = new Element(new Position(21,20));
        Assertions.assertNotEquals(element, element1);
    }
    @Test
    public void nullElement(){
        Element element = new Element(new Position(20,20));
        Assertions.assertNotEquals(element, null);
    }
}
