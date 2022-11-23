/*package org.l06gr06.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.Game;
import org.l06gr06.controller.game.BeastController;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.Position;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.game.elements.Player;
import org.l06gr06.model.game.elements.Beast;
import org.l06gr06.model.game.elements.Wall;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BeastControllerTest {
    private BeastController controller;
    private Player player;
    private Arena arena;
    private Game game;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);

        player = new Player(5, 5);
        arena.setPlayer(player);

        arena.setWalls(Arrays.asList());
        arena.setBeasts(Arrays.asList());

        controller = new BeastController(arena);

        game = Mockito.mock(Game.class);
    }

    @Test
    void moveBeasts() throws IOException {
        Beast beast = new Beast(5, 5);
        arena.setBeasts(Arrays.asList(beast));

        controller.step(game, GUI.ACTION.NONE, 1000);

        assertNotEquals(new Position(5, 5), beast.getPosition());
    }

    @Test
    void moveBeastsClosed() throws IOException {

        Beast beast = new Beast(5, 5);
        arena.setBeasts(Arrays.asList(beast));
        arena.setWalls(Arrays.asList(
                new Wall(4, 5),
                new Wall(6, 5),
                new Wall(5, 4),
                new Wall(5, 6)
        ));

        for (int i = 0; i < 10; i++)
            controller.step(game, GUI.ACTION.NONE, 1000);

        assertEquals(new Position(5, 5), beast.getPosition());
    }

    @Test
    void moveBeastsGap() throws IOException {
        Beast beast = new Beast(5, 5);
        arena.setBeasts(Arrays.asList(beast));
        arena.setWalls(Arrays.asList(
                new Wall(4, 5),
                new Wall(6, 5),
                new Wall(5, 4)
        ));

        long time = 0;

        while (beast.getPosition().equals(new Position(5, 5))) {
            time += 500;
            controller.step(game, GUI.ACTION.NONE, time);
        }

        assertEquals(new Position(5, 6), beast.getPosition());
    }
}
*/