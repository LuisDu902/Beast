package org.l06gr06.viewer.menu;

import org.l06gr06.gui.GUI;
import org.l06gr06.model.Position;

import org.l06gr06.model.game.arena.LoaderArenaBuilder;
import org.l06gr06.model.menu.ScoreMenu;
import org.l06gr06.viewer.Viewer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ScoreMenuViewer extends Viewer<ScoreMenu>{

    private List<String> lines;
    public ScoreMenuViewer(ScoreMenu menu) throws IOException {
        super(menu);
        URL resource = ScoreMenuViewer.class.getResource("/score.csv");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);
    }
    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }
    private void drawTitle(GUI gui){
        gui.drawText(new Position(2, 2), "ScoreBoard", "#FFFFFF");
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
    private void drawScores(GUI gui){
        for (int i = 0; i < lines.size(); i++){
            String[] line = lines.get(i).split(",");
            for (int j = 0; j < line.length; j++){
                gui.drawText(new Position(j*11+7,i+5),line[j],"#FFFFFF");
            }
        }
    }


    @Override
    public void drawElements(GUI gui) {

        drawTitle(gui);

        drawBoarders(gui);


        for (int i = 1; i <= 10; i++)
            gui.drawText(new Position(2,i+5), i+".", "#FFFFFF");
        drawScores(gui);
        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(20, 16 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
