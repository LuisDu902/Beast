package org.l06gr06.viewer.menu;

import org.l06gr06.gui.GUI;
import org.l06gr06.model.Position;
import org.l06gr06.model.menu.LevelMenu;
import org.l06gr06.viewer.Viewer;

public class LevelMenuViewer extends Viewer<LevelMenu> {
    public LevelMenuViewer(LevelMenu menu) {
        super(menu);
    }
    private void drawBoarders(GUI gui){
        for (int x = 0; x < 50; x++) {
            gui.drawWall(new Position(x,-3));
            gui.drawWall(new Position(x,19));
        }

        for (int y = -2; y < 19; y++) {
            gui.drawWall(new Position(0,y));
            gui.drawWall(new Position(49,y));
        }
    }


    @Override
    public void drawElements(GUI gui) {

        gui.drawText(new Position(20, 5), "LEVELS", "#FFFFFF");

        drawBoarders(gui);
        for (int i = 0; i < getModel().getNumberEntries()-1; i++) {
            gui.drawText(
                    new Position(20, 9 + 2 * i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFFF66" : "#FFFFFF");
            for (int j = i; j < getModel().getNumberEntries()-1; j++)
                gui.drawText( new Position(15+j, 13 - 2 * i), "~", "#FFFF66");
        }
        gui.drawText(new Position(20,17),getModel().getEntry(getModel().getNumberEntries()-1),getModel().isSelected(getModel().getNumberEntries()-1) ? "#FFFF66" : "#FFFFFF");
    }
}
