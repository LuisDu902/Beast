package org.l06gr06.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.controller.game.BeastController;
import org.l06gr06.controller.game.PlayerController;
import org.l06gr06.model.Position;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.game.elements.Beast;
import org.l06gr06.model.game.elements.Player;

import java.util.List;

public class BeastControllerTest {
    private BeastController controller;
    private Beast egg;
    private Beast beast;
    private Beast strongerBeast;
    private Arena arena;

    /*public class BeastControllerStub extends BeastController{
        public BeastControllerStub(Arena arena) {
            super(arena);
        }

        public void testMoveBeast(Beast beast, Position pos) {
            moveBeast(beast,pos);
        }
    }*/
    @BeforeEach
    void setUp() {
        arena = new Arena(20, 20);

        egg = new Beast(6,5,0);
        beast = new Beast(7, 5,1);
        strongerBeast = new Beast(8,5,2);

        arena.setPlayer(new Player(5,5));
        arena.setWalls(List.of());
        arena.setPowerUps(List.of());
        arena.setBlocks(List.of());
        arena.setBeasts(List.of(egg,beast,strongerBeast));

        controller = new BeastController(arena);
    }

    @Test
    void egg(){

    }

}
