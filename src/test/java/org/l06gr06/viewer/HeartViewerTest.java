package org.l06gr06.viewer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.game.elements.Heart;
import org.l06gr06.viewer.game.HeartViewer;
import org.mockito.Mockito;

public class HeartViewerTest {
    private Heart heart;
    private HeartViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        heart = new Heart(20, 20);
        viewer = new HeartViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(heart, gui);
        Mockito.verify(gui, Mockito.times(1)).drawHeart(heart.getPosition());
    }
}
