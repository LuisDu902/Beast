package org.l06gr06.controller;

import org.junit.jupiter.api.*;
import org.l06gr06.controller.game.HeroController;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.Position;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.game.elements.Block;
import org.l06gr06.model.game.elements.Hero;
import org.l06gr06.model.game.elements.Wall;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;

public class HeroControllerTest {
    private HeroController controller;
    private Hero hero;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);

        hero = new Hero(5, 5);
        arena.setHero(hero);

        arena.setWalls(Arrays.asList());
        arena.setEggs(Arrays.asList());
        arena.setPowerUps(Arrays.asList());
        arena.setBlocks(Arrays.asList());
        arena.setMonsters(Arrays.asList());

        controller = new HeroController(arena);
    }

    @Test
    void moveHeroRightEmpty() {
        controller.moveHeroRight(GUI.ACTION.RIGHT);
        assertEquals(new Position(6, 5), hero.getPosition());
    }

    @Test
    void moveHeroRightMoveBlock() {
        arena.setBlocks(Arrays.asList(new Block(6, 5)));
        controller.moveHeroRight(GUI.ACTION.RIGHT);
        assertEquals(new Position(6, 5), hero.getPosition());
        assertEquals(new Position(7, 5), arena.getBlocks().get(0).getPosition());
    }

    @Test
    void moveHeroRightNoMoveBlock() {
        arena.setBlocks(Arrays.asList(new Block(6, 5)));
        arena.setWalls(Arrays.asList(new Wall(7, 5)));
        controller.moveHeroRight(GUI.ACTION.RIGHT);
        assertEquals(new Position(5, 5), hero.getPosition());
        assertEquals(new Position(6, 5), arena.getBlocks().get(0).getPosition());
        assertEquals(new Position(7, 5), arena.getWalls().get(0).getPosition());
    }

    @Test
    void moveHeroRightWall() {
        arena.setWalls(Arrays.asList(new Wall(6, 5)));
        controller.moveHeroRight(GUI.ACTION.RIGHT);
        assertEquals(new Position(5, 5), hero.getPosition());
    }

    @Test
    void moveHeroLeftEmpty() {
        controller.moveHeroLeft(GUI.ACTION.LEFT);
        assertEquals(new Position(4, 5), hero.getPosition());
    }

    @Test
    void moveHeroLeftMoveBlock() {
        arena.setBlocks(Arrays.asList(new Block(4, 5)));
        controller.moveHeroLeft(GUI.ACTION.LEFT);
        assertEquals(new Position(4, 5), hero.getPosition());
        assertEquals(new Position(3, 5), arena.getBlocks().get(0).getPosition());
    }

    @Test
    void moveHeroLeftNoMoveBlock() {
        arena.setBlocks(Arrays.asList(new Block(4, 5)));
        arena.setWalls(Arrays.asList(new Wall(3, 5)));
        controller.moveHeroLeft(GUI.ACTION.LEFT);
        assertEquals(new Position(5, 5), hero.getPosition());
        assertEquals(new Position(4, 5), arena.getBlocks().get(0).getPosition());
        assertEquals(new Position(3, 5), arena.getWalls().get(0).getPosition());
    }

    @Test
    void moveHeroLeftWall() {
        arena.setWalls(Arrays.asList(new Wall(4, 5)));
        controller.moveHeroLeft(GUI.ACTION.LEFT);
        assertEquals(new Position(5, 5), hero.getPosition());
    }

    @Test
    void moveHeroUpEmpty() {
        controller.moveHeroUp(GUI.ACTION.UP);
        assertEquals(new Position(5, 4), hero.getPosition());
    }

    @Test
    void moveHeroUpMoveBlock() {
        arena.setBlocks(Arrays.asList(new Block(5, 4)));
        controller.moveHeroUp(GUI.ACTION.UP);
        assertEquals(new Position(5, 4), hero.getPosition());
        assertEquals(new Position(5, 3), arena.getBlocks().get(0).getPosition());
    }

    @Test
    void moveHeroUpNoMoveBlock() {
        arena.setBlocks(Arrays.asList(new Block(5, 4)));
        arena.setWalls(Arrays.asList(new Wall(5, 3)));
        controller.moveHeroUp(GUI.ACTION.UP);
        assertEquals(new Position(5, 5), hero.getPosition());
        assertEquals(new Position(5, 4), arena.getBlocks().get(0).getPosition());
        assertEquals(new Position(5, 3), arena.getWalls().get(0).getPosition());
    }

    @Test
    void moveHeroUpWall() {
        arena.setWalls(Arrays.asList(new Wall(5, 4)));
        controller.moveHeroUp(GUI.ACTION.UP);
        assertEquals(new Position(5, 5), hero.getPosition());
    }
    @Test
    void moveHeroDownEmpty() {
        controller.moveHeroDown(GUI.ACTION.DOWN);
        assertEquals(new Position(5, 6), hero.getPosition());
    }

    @Test
    void moveHeroDownMoveBlock() {
        arena.setBlocks(Arrays.asList(new Block(5, 6)));
        controller.moveHeroDown(GUI.ACTION.DOWN);
        assertEquals(new Position(5, 6), hero.getPosition());
        assertEquals(new Position(5, 7), arena.getBlocks().get(0).getPosition());
    }

    @Test
    void moveHeroDownNoMoveBlock() {
        arena.setBlocks(Arrays.asList(new Block(5, 6)));
        arena.setWalls(Arrays.asList(new Wall(5, 7)));
        controller.moveHeroDown(GUI.ACTION.DOWN);
        assertEquals(new Position(5, 5), hero.getPosition());
        assertEquals(new Position(5, 6), arena.getBlocks().get(0).getPosition());
        assertEquals(new Position(5, 7), arena.getWalls().get(0).getPosition());
    }

    @Test
    void moveHeroDownWall() {
        arena.setWalls(Arrays.asList(new Wall(5, 6)));
        controller.moveHeroDown(GUI.ACTION.DOWN);
        assertEquals(new Position(5, 5), hero.getPosition());
    }

}
