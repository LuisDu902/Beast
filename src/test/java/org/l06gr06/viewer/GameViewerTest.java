package org.l06gr06.viewer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.Position;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.game.elements.*;
import org.l06gr06.viewer.game.GameViewer;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;
public class GameViewerTest {
    private GUI gui;
    private GameViewer viewer;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);
        gui = Mockito.mock(GUI.class);
        viewer = new GameViewer(arena);

        arena.setWalls(Arrays.asList(new Wall(1, 2), new Wall(2, 3), new Wall(3, 4)));
        arena.setBeasts(Arrays.asList(new Beast(4, 5), new Beast(5, 6)));
        arena.setPlayer(new Player(5, 8));
        arena.setBlocks(Arrays.asList(new Block(6, 7), new Block(7, 7), new Block(7, 8)));
        arena.setEggs(Arrays.asList(new Egg(6, 6), new Egg(6, 5), new Egg(6, 4)));
        arena.setPowerUps(Arrays.asList(new Heart(1, 1), new Shield(8, 8), new Heart(9, 9)));
    }


    @Test
    void drawWalls() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(1, 2));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(2, 3));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(3, 4));
        Mockito.verify(gui, Mockito.times(3)).drawWall(Mockito.any(Position.class));
    }

    @Test
    void drawBeasts() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawBeast(0,new Position(4, 5));
        Mockito.verify(gui, Mockito.times(1)).drawBeast(0,new Position(5, 6));
        Mockito.verify(gui, Mockito.times(2)).drawBeast(Mockito.anyInt(),Mockito.any(Position.class));
    }

    @Test
    void drawPlayer() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawPlayer(new Position(5, 8));
        Mockito.verify(gui, Mockito.times(1)).drawPlayer(Mockito.any(Position.class));
    }

    @Test
    void drawBlocks() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawBlock(new Position(6, 7));
        Mockito.verify(gui, Mockito.times(1)).drawBlock(new Position(7, 7));
        Mockito.verify(gui, Mockito.times(1)).drawBlock(new Position(7, 8));
        Mockito.verify(gui, Mockito.times(3)).drawBlock(Mockito.any(Position.class));
    }
    @Test
    void drawEggs() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawEgg(new Position(6, 6));
        Mockito.verify(gui, Mockito.times(1)).drawEgg(new Position(6, 5));
        Mockito.verify(gui, Mockito.times(1)).drawEgg(new Position(6, 4));
        Mockito.verify(gui, Mockito.times(3)).drawEgg(Mockito.any(Position.class));
    }
    @Test
    void drawPowerUps() throws IOException {
        viewer.draw(gui);

        //Mockito.verify(gui, Mockito.times(1)).drawHeart(new Position(1, 1));
        Mockito.verify(gui, Mockito.times(1)).drawShield(new Position(8, 8));
        //Mockito.verify(gui, Mockito.times(1)).drawHeart(new Position(9, 9));
        //Mockito.verify(gui, Mockito.times(2)).drawHeart(Mockito.any(Position.class));
        //Mockito.verify(gui, Mockito.times(1)).drawShield(Mockito.any(Position.class));
    }
    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}
