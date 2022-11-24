package org.l06gr06.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.model.game.elements.Player;
import org.l06gr06.model.game.elements.Beast;
import org.l06gr06.model.game.elements.Shield;

public class ElementsTest {

    @Test
    public void IncreaseLife(){
        Player player = new Player(20,20);
        player.increaseLife();
        Assertions.assertEquals(6, player.getLife());
    }

    @Test
    public void Shield(){
        Shield shield = new Shield(20,20);
        shield.decreaseTimer();
        Assertions.assertEquals(9, shield.getTimer());
    }

    @Test
    public void Beast(){
        Beast beast = new Beast(20,20);
        beast.evolve();
        Assertions.assertEquals(1, beast.getPhase());
    }

    @Test
    public void DecreaseLife(){
        Player player = new Player(20,20);
        player.decreaseLife();
        Assertions.assertEquals(4, player.getLife());
    }
}
