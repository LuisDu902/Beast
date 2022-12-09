package org.l06gr06.viewer.menu;

import org.l06gr06.gui.GUI;
import org.l06gr06.model.Position;
import org.l06gr06.model.menu.MainMenu;
import org.l06gr06.viewer.Viewer;

public class MainMenuViewer extends Viewer<MainMenu> {
    public MainMenuViewer(MainMenu menu) {
        super(menu);
    }
    private void drawTitle(GUI gui){
        gui.drawText(new Position(6, 3), "HHHH     HHHHH    HHH     HHHH   HHHHH", "#FFFFFF");
        gui.drawText(new Position(6, 4), "H   H    H       H   H   H         H", "#FFFFFF");
        gui.drawText(new Position(6, 5), "H   H    H       H   H   H         H"  , "#FFFFFF");
        gui.drawText(new Position(6, 6), "HHHH     HHH     HH HH    HHH      H", "#FFFFFF");
        gui.drawText(new Position(6, 7), "H   H    H       H   H       H     H", "#FFFFFF");
        gui.drawText(new Position(6, 8), "H   H    H       H   H       H     H", "#FFFFFF");
        gui.drawText(new Position(6, 9), "HHHH     HHHHH   H   H   HHHH      H", "#FFFFFF");
        gui.drawText(new Position(25, 6), "&", "#00FFEF");
    }
    @Override
    public void drawElements(GUI gui) {

       drawTitle(gui);

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(15, 18 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFFF66" : "#FFFFFF");
    }
}
