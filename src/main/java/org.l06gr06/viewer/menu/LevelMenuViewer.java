package org.l06gr06.viewer.menu;

import org.l06gr06.gui.GUI;
import org.l06gr06.model.Position;
import org.l06gr06.model.menu.Menu;
import org.l06gr06.viewer.Viewer;

public class LevelMenuViewer extends Viewer<Menu> {
    public LevelMenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {

        gui.drawText(new Position(5, 5), "Levels", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
