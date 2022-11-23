package org.l06gr06.viewer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.game.elements.Beast;
import org.l06gr06.viewer.game.BeastViewer;
import org.mockito.Mockito;

public class BeastViewerTest {
    private Beast beast;
    private BeastViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        beast = new Beast(20, 20);
        viewer = new BeastViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(beast, gui);
        Mockito.verify(gui, Mockito.times(1)).drawBeast(0,beast.getPosition());
    }
}