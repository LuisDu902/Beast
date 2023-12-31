package org.l06gr06.viewer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.game.elements.Wall;
import org.l06gr06.viewer.game.WallViewer;
import org.mockito.Mockito;

public class WallViewerTest {
    private Wall wall;
    private WallViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        wall = new Wall(20, 20);
        viewer = new WallViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(wall, gui);
        Mockito.verify(gui, Mockito.times(1)).drawWall(wall.getPosition());
    }
}