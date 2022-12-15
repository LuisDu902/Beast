package org.l06gr06.model;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {
    @Property
    void getLeft(@ForAll int x, @ForAll int y) {
        assertEquals(x - 1, new Position(x, y).getLeft().getX());
        assertEquals(y, new Position(x, y).getLeft().getY());
    }

    @Property
    void getRight(@ForAll int x, @ForAll int y) {
        assertEquals(x + 1, new Position(x, y).getRight().getX());
        assertEquals(y, new Position(x, y).getRight().getY());
    }

    @Property
    void getUp(@ForAll int x, @ForAll int y) {
        assertEquals(x, new Position(x, y).getUp().getX());
        assertEquals(y - 1, new Position(x, y).getUp().getY());
    }

    @Property
    void getDown(@ForAll int x, @ForAll int y) {
        assertEquals(x, new Position(x, y).getDown().getX());
        assertEquals(y + 1, new Position(x, y).getDown().getY());
    }

    @Property
    void getDownLeft(@ForAll int x, @ForAll int y) {
        assertEquals(x - 1, new Position(x, y).getDownLeft().getX());
        assertEquals(y + 1, new Position(x, y).getDownLeft().getY());
    }
    @Property
    void getDownRight(@ForAll int x, @ForAll int y) {
        assertEquals(x + 1, new Position(x, y).getDownRight().getX());
        assertEquals(y + 1, new Position(x, y).getDownRight().getY());
    }
    @Property
    void getUpLeft(@ForAll int x, @ForAll int y) {
        assertEquals(x - 1, new Position(x, y).getUpLeft().getX());
        assertEquals(y - 1, new Position(x, y).getUpLeft().getY());
    }
    @Property
    void getUpRight(@ForAll int x, @ForAll int y) {
        assertEquals(x + 1, new Position(x, y).getUpRight().getX());
        assertEquals(y - 1, new Position(x, y).getUpRight().getY());
    }
    @Property
    void goLeft(@ForAll int x, @ForAll int y) {
        Position position = new Position(x,y);
        position.goLeft();
        assertEquals(x-1, position.getX());
        assertEquals(y, position.getY());
    }
    @Property
    void goRight(@ForAll int x, @ForAll int y) {
        Position position = new Position(x,y);
        position.goRight();
        assertEquals(x+1, position.getX());
        assertEquals(y, position.getY());
    }
    @Property
    void goUp(@ForAll int x, @ForAll int y) {
        Position position = new Position(x,y);
        position.goUp();
        assertEquals(x, position.getX());
        assertEquals(y-1, position.getY());
    }
    @Property
    void goDown(@ForAll int x, @ForAll int y) {
        Position position = new Position(x,y);
        position.goDown();
        assertEquals(x, position.getX());
        assertEquals(y+1, position.getY());
    }

}