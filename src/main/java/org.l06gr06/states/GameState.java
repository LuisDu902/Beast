package org.l06gr06.states;

import org.l06gr06.controller.Controller;
import org.l06gr06.controller.game.ArenaController;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.viewer.Viewer;
import org.l06gr06.viewer.game.GameViewer;

public class GameState extends State<Arena>{

    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }

}
