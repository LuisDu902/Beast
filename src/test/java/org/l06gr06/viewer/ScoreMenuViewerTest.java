package org.l06gr06.viewer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.gui.GUI;

import org.l06gr06.model.Position;
import org.l06gr06.model.menu.ScoreMenu;
import org.l06gr06.viewer.Viewer;
import org.l06gr06.viewer.menu.ScoreMenuViewer;
import org.mockito.Mockito;

import java.util.Arrays;

public class ScoreMenuViewerTest {
    private GUI gui;
    private Viewer viewer;
    private ScoreMenu scoreMenu;
    @BeforeEach
    void setUp() {
        scoreMenu = new ScoreMenu((Arrays.asList("GameOver","Play Again", "Exit")));
        viewer = new ScoreMenuViewer(scoreMenu);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawText(){
        viewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1+scoreMenu.getNumberEntries())).drawText(Mockito.any(Position.class),Mockito.any(String.class),Mockito.any(String.class));
    }
}
