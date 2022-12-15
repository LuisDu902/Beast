package org.l06gr06.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.controller.game.PowerUpController;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.game.elements.Player;
import org.l06gr06.model.game.elements.PowerUp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerUpControllerTest {
    private PowerUpController controller;
    private PowerUp powerUp;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(20, 20);


        List<PowerUp> powerUps = new ArrayList<>();
        powerUp = new PowerUp(6,5);
        powerUps.add(powerUp);

        arena.setPlayer(new Player(5, 5));
        arena.setWalls(new ArrayList<>());
        arena.setPowerUps(powerUps);
        arena.setBlocks(new ArrayList<>());
        arena.setBeasts(new ArrayList<>());

        controller = new PowerUpController(arena);
    }

    @Test
    void createPowerUp() throws IOException {
        assertEquals(1, arena.getPowerUps().size());

        controller.step(null, GUI.ACTION.RIGHT,5*1000+ arena.getStartingTime());

        assertEquals(2, arena.getPowerUps().size());

    }

    @Test
    void removePowerUp() throws IOException {
        assertEquals(1, arena.getPowerUps().size());

        powerUp.setDuration(2);
        controller.step(null, GUI.ACTION.RIGHT,2001+ arena.getStartingTime());

        assertEquals(0, arena.getPowerUps().size());

    }
}
