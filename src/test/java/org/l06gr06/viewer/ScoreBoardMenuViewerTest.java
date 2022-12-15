package org.l06gr06.viewer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.Position;
import org.l06gr06.model.menu.ScoreBoardMenu;
import org.l06gr06.viewer.menu.ScoreBoardMenuViewer;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

public class ScoreBoardMenuViewerTest {
    private GUI gui;
    private Viewer viewer;
    private ScoreBoardMenu scoreBoardMenu;
    @BeforeEach
    void setUp() throws IOException {

        scoreBoardMenu = new ScoreBoardMenu(Arrays.asList("Play Again","ScoreBoard", "Exit"));
        viewer = new ScoreBoardMenuViewer(scoreBoardMenu,"score.csv");
        gui = Mockito.mock(GUI.class);
    }
    /*
    @Test
    void drawText(){
        viewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(scoreBoardMenu.getNumberEntries())).drawText(Mockito.any(Position.class),Mockito.any(String.class),Mockito.any(String.class));
    }*/
}
