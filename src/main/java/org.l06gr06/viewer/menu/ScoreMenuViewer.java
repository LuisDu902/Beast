package org.l06gr06.viewer.menu;

import org.l06gr06.gui.GUI;
import org.l06gr06.model.Position;
import org.l06gr06.model.menu.ScoreMenu;
import org.l06gr06.viewer.Viewer;

public class ScoreMenuViewer extends Viewer<ScoreMenu>{

    public ScoreMenuViewer(ScoreMenu menu) {
        super(menu);
    }

    private void drawTitle(GUI gui){
        gui.drawText(new Position(20, 2), "Your Score", "#FFFFFF");
    }

    private void drawBoarders(GUI gui){
        for (int x = 0; x < 50; x++) {
            gui.drawWall(new Position(x,-1));
            gui.drawWall(new Position(x,19));
        }

        for (int y = 0; y < 19; y++) {
            gui.drawWall(new Position(0,y));
            gui.drawWall(new Position(49,y));
        }
    }

    private void drawScore(GUI gui){
        long stats[] = getModel().getStats();
        for (int i = 0; i < 3; i++){
            gui.drawText(new Position(28,i+4), stats[i] + " x","#FFFFFF");
            gui.drawBeast(i,new Position(32,i+1));
        }

        gui.drawText(new Position(13,5), "Beasts killed: ","#FFFFFF");

        gui.drawText(new Position(28,8), stats[3] + " x","#FFFFFF");
        gui.drawShield(new Position(32,5));

        gui.drawText(new Position(13,8), "      Shields: ","#FFFFFF");

        gui.drawText(new Position(10,10), " Remaining Lives: ","#FFFFFF");
        gui.drawText(new Position(28,10), stats[4] + " x","#FFFFFF");
        gui.drawHeart(new Position(32,7));
        long min = stats[5]/60;
        long sec = stats[5]%60;
        String txt = String.format("%02d:%02d", min, sec);
        gui.drawText(new Position(13,12), "         Time: " + txt,"#FFFFFF");

        long score = stats[0]*75 + stats[1]* 150 + stats[2] * 300 + stats[3] * 50 + stats[4] * 50 - stats[5];
        gui.drawText(new Position(13,14), " Final points: " + score,"#a64dff");
    }

    @Override
    public void drawElements(GUI gui) {

        drawTitle(gui);

        drawBoarders(gui);

        drawScore(gui);

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(5+i*17, 17),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
