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
        Assertions.assertEquals(1, player.getPhase());
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
    public void Equal(){
        Element element = new Element(new Position(20,20));
        Assertions.assertEquals(new Element(new Position(20,20)),element);
    }
}
