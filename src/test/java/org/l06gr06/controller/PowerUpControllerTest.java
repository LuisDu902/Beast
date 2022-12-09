package org.l06gr06.controller;

import org.junit.jupiter.api.BeforeEach;
import org.l06gr06.controller.game.PowerUpController;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.game.elements.Beast;
import org.l06gr06.model.game.elements.Heart;
import org.l06gr06.model.game.elements.Player;
import org.l06gr06.model.game.elements.Shield;

import java.util.List;

public class PowerUpControllerTest {
    private PowerUpController controller;
    private Heart heart;
    private Shield shield;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(20, 20);

        heart = new Heart(6, 5);
        shield = new Shield(7, 5);

        arena.setPlayer(new Player(5, 5));

        arena.setWalls(List.of());
        arena.setPowerUps(List.of(heart, shield));
        arena.setBlocks(List.of());
        arena.setBeasts(List.of());

        controller = new PowerUpController(arena);
    }
    
}
