package org.l06gr06.controller.game;

import org.l06gr06.Game;
/*
import org.l06gr06.gui.GUI;
import org.l06gr06.model.Position;
import org.l06gr06.model.game.arena.Arena;
*/

public class BlockController extends GameController {
    public BlockController(Arena arena) {
        super(arena);
    }

    public void moveBlockLeft() {
        //to be implemented...
    }

    public void moveBlockRight() {
        //to be implemented...
    }

    public void moveBlockUp() {
        //to be implemented...
    }

    public void moveBlockDown() {
        //to be implemented...
    }

    private void moveBlock(Position position) {
        //to be implemented...
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) moveBlockUp();
        if (action == GUI.ACTION.RIGHT) moveBlockRight();
        if (action == GUI.ACTION.DOWN) moveBlockDown();
        if (action == GUI.ACTION.LEFT) moveBlockLeft();
    }
}
