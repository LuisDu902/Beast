package org.l06gr06.viewer.menu;

import org.l06gr06.gui.GUI;
import org.l06gr06.model.Position;
import org.l06gr06.model.menu.LevelMenu;
import org.l06gr06.viewer.Viewer;

public class LevelMenuViewer extends Viewer<LevelMenu> {
    public LevelMenuViewer(LevelMenu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {

        gui.drawText(new Position(20, 5), "Levels", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries()-1; i++)
            gui.drawText(
                    new Position(20, 10 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFFF66" : "#FFFFFF");
        gui.drawText(new Position(20,15),getModel().getEntry(getModel().getNumberEntries()-1),getModel().isSelected(getModel().getNumberEntries()-1) ? "#FFFF66" : "#FFFFFF");
    }
}
