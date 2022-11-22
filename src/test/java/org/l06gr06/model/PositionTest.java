package org.l06gr06.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;

public class PositionTest {
    private Position pos;

    @BeforeEach
    void setUp(){
        pos = new Position(20,20);
    }
    @Test
    public void getLeft() {
        Position test = pos.getLeft();
        Position expected = new Position(19,20);
        Assertions.assertEquals(expected, test);
    }
    @Test
    public void getRight() {
        Position test = pos.getRight();
        Position expected = new Position(21,20);
        Assertions.assertEquals(expected, test);
    }
    @Test
    public void getUp() {
        Position test = pos.getUp();
        Position expected = new Position(20,19);
        Assertions.assertEquals(expected, test);
    }
    @Test
    public void getDown() {
        Position test = pos.getDown();
        Position expected = new Position(20,21);
        Assertions.assertEquals(expected, test);
    }
}
