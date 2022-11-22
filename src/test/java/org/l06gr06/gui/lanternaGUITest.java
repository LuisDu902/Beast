package org.l06gr06.gui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.model.Position;
import org.mockito.Mockito;

public class lanternaGUITest {

    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics tg;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);

        Mockito.when(screen.newTextGraphics()).thenReturn(tg);

        gui = new LanternaGUI(screen);
    }

    @Test
    void drawHero() {
        gui.drawHero(new Position(20, 20));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 51, 255));
        Mockito.verify(tg, Mockito.times(1)).putString(20, 21, "H");
    }

    @Test
    void drawMonster() {
        gui.drawMonster(new Position(20, 20));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(232, 14, 14));
        Mockito.verify(tg, Mockito.times(1)).putString(20, 21, "M");
    }

    @Test
    void drawShield() {
        gui.drawShield(new Position(20, 20));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(tg, Mockito.times(1)).putString(20, 21, "e");
    }
    @Test
    void drawAdultMonster() {
        gui.drawAdultMonster(new Position(20, 20));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 215, 0));
        Mockito.verify(tg, Mockito.times(1)).putString(20, 21, "M");
    }
    @Test
    void drawHeart() {
        gui.drawHeart(new Position(20, 20));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(252,8,8));
        Mockito.verify(tg, Mockito.times(1)).putString(20, 21, "@");
    }
    @Test
    void drawBlock() {
        gui.drawBlock(new Position(20, 20));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(29,194,73));
        Mockito.verify(tg, Mockito.times(1)).putString(20, 21, "O");
    }

    @Test
    void drawWall() {
        gui.drawWall(new Position(20, 20));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(245, 245, 5));
        Mockito.verify(tg, Mockito.times(1)).putString(20, 21, "#");
    }

    @Test
    void drawText() {
        gui.drawText(new Position(20, 20), "Beast Game", "#336699");

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        Mockito.verify(tg, Mockito.times(1)).putString(20,20, "Beast Game");
    }
}

