package org.l06gr06.states;

import org.l06gr06.controller.Controller;
import org.l06gr06.controller.menu.LevelMenuController;
import org.l06gr06.model.menu.LevelMenu;
import org.l06gr06.viewer.Viewer;
import org.l06gr06.viewer.menu.LevelMenuViewer;

public class LevelState extends State<LevelMenu>{

    public LevelState(LevelMenu model){super(model);}

    protected Viewer<LevelMenu> getViewer(){return new LevelMenuViewer(getModel());}

    protected Controller<LevelMenu> getController(){return new LevelMenuController(getModel());}

}
