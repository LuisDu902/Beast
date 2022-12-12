package org.l06gr06.states;

import org.l06gr06.controller.Controller;
import org.l06gr06.controller.menu.ScoreBoardMenuController;
import org.l06gr06.model.menu.ScoreBoardMenu;
import org.l06gr06.viewer.Viewer;
import org.l06gr06.viewer.menu.ScoreBoardMenuViewer;

import java.io.IOException;

public class ScoreBoardMenuState extends State<ScoreBoardMenu>{

    public ScoreBoardMenuState(ScoreBoardMenu model) throws IOException {super(model);}
    @Override
    protected Viewer<ScoreBoardMenu> getViewer() throws IOException {return new ScoreBoardMenuViewer(getModel(),"score.csv");}
    @Override
    protected Controller<ScoreBoardMenu> getController(){return new ScoreBoardMenuController(getModel());}

}
