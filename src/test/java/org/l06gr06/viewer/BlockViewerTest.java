package org.l06gr06.viewer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.game.elements.Block;
import org.l06gr06.viewer.game.BlockViewer;
import org.mockito.Mockito;

public class BlockViewerTest {
    private Block block;
    private BlockViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        block = new Block(20, 20);
        viewer = new BlockViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(block, gui);
        Mockito.verify(gui, Mockito.times(1)).drawBlock(block.getPosition());
    }
}
