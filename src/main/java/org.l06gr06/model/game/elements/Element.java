package org.l06gr06.model.game.elements;

import org.l06gr06.model.Position;
import org.l06gr06.viewer.game.ElementViewer;

public class Element {
    private Position position;
    protected ElementViewer<Element> viewer;
    public Element(int x, int y) {
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
