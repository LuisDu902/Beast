package org.l06gr06.viewer.menu;

import org.l06gr06.gui.GUI;
import org.l06gr06.model.Position;
import org.l06gr06.model.menu.ScoreBoardMenu;
import org.l06gr06.viewer.Viewer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ScoreBoardMenuViewer extends Viewer<ScoreBoardMenu>{

    private List<String> lines;
    public ScoreBoardMenuViewer(ScoreBoardMenu menu) throws IOException {
        super(menu);
        URL resource = ScoreBoardMenu.class.getResource("/levels/score.csv");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);
    }
    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        lines.sort(((Comparator<String>) (o1, o2) -> {
            String score1 = o1.split(",")[1];
            String score2 = o2.split(",")[1];
            return Integer.compare(Integer.parseInt(score1), Integer.parseInt(score2));
        }).reversed());
        return lines;
    }
    private void drawTitle(GUI gui){
        gui.drawText(new Position(2, 2), "ScoreBoard", "#FFFFFF");
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
    private void drawScores(GUI gui){
        gui.drawText(new Position(7,5),"Level","#FFFFFF");
        gui.drawText(new Position(18,5),"Score","#FFFFFF");
        gui.drawText(new Position(29,5),"Time","#FFFFFF");
        int size = Math.min(lines.size(), 10);
        for (int i = 0; i < size; i++){
            gui.drawText(new Position(2,i+7), i+1+".", "#FFFFFF");
            String[] line = lines.get(i).split(",");
            for (int j = 0; j < line.length; j++){
                gui.drawText(new Position(j*11+7,i+7),line[j],"#FFFFFF");
            }
        }
    }


    @Override
    public void drawElements(GUI gui) {

        drawTitle(gui);

        drawBoarders(gui);

        drawScores(gui);

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(20, 16 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
    }
}
