package org.l06gr06.states;

import org.l06gr06.controller.Controller;
import org.l06gr06.controller.menu.ScoreMenuController;
import org.l06gr06.model.menu.ScoreMenu;
import org.l06gr06.viewer.Viewer;
import org.l06gr06.viewer.menu.ScoreMenuViewer;

public class ScoreState extends State<ScoreMenu>{

    public ScoreState(ScoreMenu model){super(model);}

    protected Viewer<ScoreMenu> getViewer(){return new ScoreMenuViewer(getModel());}

    protected Controller<ScoreMenu> getController(){return new ScoreMenuController(getModel());}

}
