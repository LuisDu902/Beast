package org.l06gr06.controller;

import org.junit.jupiter.api.*;
import org.l06gr06.controller.game.PlayerController;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.Position;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.game.elements.Block;
import org.l06gr06.model.game.elements.Player;
import org.l06gr06.model.game.elements.Wall;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;

public class PlayerControllerTest {
    private PlayerController controller;
    private Player player;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);

        player = new Player(5, 5);
        arena.setPlayer(player);

        arena.setWalls(Arrays.asList());
        arena.setEggs(Arrays.asList());
        arena.setPowerUps(Arrays.asList());
        arena.setBlocks(Arrays.asList());
        arena.setBeasts(Arrays.asList());

        controller = new PlayerController(arena);
    }

    @Test
    void movePlayerRightEmpty() {
        controller.movePlayerRight(GUI.ACTION.RIGHT);
        assertEquals(new Position(6, 5), player.getPosition());
    }

    @Test
    void movePlayerRightMoveBlock() {
        arena.setBlocks(Arrays.asList(new Block(6, 5)));
        controller.movePlayerRight(GUI.ACTION.RIGHT);
        assertEquals(new Position(6, 5), player.getPosition());
        assertEquals(new Position(7, 5), arena.getBlocks().get(0).getPosition());
    }

    @Test
    void movePlayerRightNoMoveBlock() {
        arena.setBlocks(Arrays.asList(new Block(6, 5)));
        arena.setWalls(Arrays.asList(new Wall(7, 5)));
        controller.movePlayerRight(GUI.ACTION.RIGHT);
        assertEquals(new Position(5, 5), player.getPosition());
        assertEquals(new Position(6, 5), arena.getBlocks().get(0).getPosition());
        assertEquals(new Position(7, 5), arena.getWalls().get(0).getPosition());
    }

    @Test
    void movePlayerRightWall() {
        arena.setWalls(Arrays.asList(new Wall(6, 5)));
        controller.movePlayerRight(GUI.ACTION.RIGHT);
        assertEquals(new Position(5, 5), player.getPosition());
    }

    @Test
    void movePlayerLeftEmpty() {
        controller.movePlayerLeft(GUI.ACTION.LEFT);
        assertEquals(new Position(4, 5), player.getPosition());
    }

    @Test
    void movePlayerLeftMoveBlock() {
        arena.setBlocks(Arrays.asList(new Block(4, 5)));
        controller.movePlayerLeft(GUI.ACTION.LEFT);
        assertEquals(new Position(4, 5), player.getPosition());
        assertEquals(new Position(3, 5), arena.getBlocks().get(0).getPosition());
    }

    @Test
    void movePlayerLeftNoMoveBlock() {
        arena.setBlocks(Arrays.asList(new Block(4, 5)));
        arena.setWalls(Arrays.asList(new Wall(3, 5)));
        controller.movePlayerLeft(GUI.ACTION.LEFT);
        assertEquals(new Position(5, 5), player.getPosition());
        assertEquals(new Position(4, 5), arena.getBlocks().get(0).getPosition());
        assertEquals(new Position(3, 5), arena.getWalls().get(0).getPosition());
    }

    @Test
    void movePlayerLeftWall() {
        arena.setWalls(Arrays.asList(new Wall(4, 5)));
        controller.movePlayerLeft(GUI.ACTION.LEFT);
        assertEquals(new Position(5, 5), player.getPosition());
    }

    @Test
    void movePlayerUpEmpty() {
        controller.movePlayerUp(GUI.ACTION.UP);
        assertEquals(new Position(5, 4), player.getPosition());
    }

    @Test
    void movePlayerUpMoveBlock() {
        arena.setBlocks(Arrays.asList(new Block(5, 4)));
        controller.movePlayerUp(GUI.ACTION.UP);
        assertEquals(new Position(5, 4), player.getPosition());
        assertEquals(new Position(5, 3), arena.getBlocks().get(0).getPosition());
    }

    @Test
    void movePlayerUpNoMoveBlock() {
        arena.setBlocks(Arrays.asList(new Block(5, 4)));
        arena.setWalls(Arrays.asList(new Wall(5, 3)));
        controller.movePlayerUp(GUI.ACTION.UP);
        assertEquals(new Position(5, 5), player.getPosition());
        assertEquals(new Position(5, 4), arena.getBlocks().get(0).getPosition());
        assertEquals(new Position(5, 3), arena.getWalls().get(0).getPosition());
    }

    @Test
    void movePlayerUpWall() {
        arena.setWalls(Arrays.asList(new Wall(5, 4)));
        controller.movePlayerUp(GUI.ACTION.UP);
        assertEquals(new Position(5, 5), player.getPosition());
    }
    @Test
    void movePlayerDownEmpty() {
        controller.movePlayerDown(GUI.ACTION.DOWN);
        assertEquals(new Position(5, 6), player.getPosition());
    }

    @Test
    void movePlayerDownMoveBlock() {
        arena.setBlocks(Arrays.asList(new Block(5, 6)));
        controller.movePlayerDown(GUI.ACTION.DOWN);
        assertEquals(new Position(5, 6), player.getPosition());
        assertEquals(new Position(5, 7), arena.getBlocks().get(0).getPosition());
    }

    @Test
    void movePlayerDownNoMoveBlock() {
        arena.setBlocks(Arrays.asList(new Block(5, 6)));
        arena.setWalls(Arrays.asList(new Wall(5, 7)));
        controller.movePlayerDown(GUI.ACTION.DOWN);
        assertEquals(new Position(5, 5), player.getPosition());
        assertEquals(new Position(5, 6), arena.getBlocks().get(0).getPosition());
        assertEquals(new Position(5, 7), arena.getWalls().get(0).getPosition());
    }

    @Test
    void movePlayerDownWall() {
        arena.setWalls(Arrays.asList(new Wall(5, 6)));
        controller.movePlayerDown(GUI.ACTION.DOWN);
        assertEquals(new Position(5, 5), player.getPosition());
    }

}
