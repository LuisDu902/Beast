package org.l06gr06.controller;

import org.l06gr06.Game;
import org.l06gr06.gui.GUI;

import java.io.IOException;

public abstract class Controller<T> {
    private T model;
    public Controller(T model) {
        this.model = model;
    }
    public T getModel() {
        return model;
    }
    public void setModel(T model){this.model = model;}
    public abstract void step(Game game, GUI.ACTION action, long time) throws IOException;
}
