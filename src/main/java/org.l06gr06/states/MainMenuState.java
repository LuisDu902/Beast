package org.l06gr06.states;

import org.l06gr06.controller.Controller;
import org.l06gr06.controller.menu.MainMenuController;
import org.l06gr06.model.menu.MainMenu;
import org.l06gr06.viewer.Viewer;
import org.l06gr06.viewer.menu.MainMenuViewer;

import java.io.IOException;

public class MainMenuState extends State<MainMenu>{

    public MainMenuState(MainMenu model) throws IOException {super(model);}
    @Override
    protected Viewer<MainMenu> getViewer(){return new MainMenuViewer(getModel());}
    @Override
    protected Controller<MainMenu> getController(){return new MainMenuController(getModel());}

}
