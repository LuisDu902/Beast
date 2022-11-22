package org.l06gr06.gui;

import java.io.IOException;

public interface GUI {

    /* To be implemented...
    void drawText(Position position, String text, String color);
    void drawHero(Position position);
    void drawShield(Position position);
    void drawWall(Position position);
    void drawHeart(Position position);
    void drawMonster(Position position);
    void drawAdultMonster(Position position);
    void drawEgg(Position position);
    void drawBlock(Position position);
    */
    ACTION getNextAction() throws IOException;
    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}

}
