package org.l06gr06.states;

import org.l06gr06.controller.Controller;
import org.l06gr06.controller.menu.ScoreMenuController;
import org.l06gr06.model.menu.ScoreMenu;
import org.l06gr06.viewer.Viewer;
import org.l06gr06.viewer.menu.ScoreMenuViewer;

import java.io.IOException;

public class ScoreMenuState extends State<ScoreMenu>{

    public ScoreMenuState(ScoreMenu model) throws IOException {super(model);}
    @Override
    protected Viewer<ScoreMenu> getViewer() throws IOException {return new ScoreMenuViewer(getModel());}
    @Override
    protected Controller<ScoreMenu> getController(){return new ScoreMenuController(getModel());}

}
