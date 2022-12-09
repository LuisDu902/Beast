package org.l06gr06.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.l06gr06.model.menu.Menu;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuTest {
    Menu menu;
    @BeforeEach
    public void helper(){
        menu = new Menu(Arrays.asList("Entry1","Entry2","Entry3","Exit"));
    }

    @Test
    public void nextEntryGeneral(){
        menu.nextEntry();
        Assertions.assertEquals(1,menu.getCurrentEntry());
    }

    @Test
    public void nextEntryForLast(){
        menu.setCurrentEntry(3);
        menu.nextEntry();
        Assertions.assertEquals(0,menu.getCurrentEntry());
    }

    @Test
    public void prevoiusEntryGeneral(){
        menu.setCurrentEntry(3);
        menu.previousEntry();
        Assertions.assertEquals(2,menu.getCurrentEntry());
    }

    @Test
    public void previousEntryForFirst(){
        menu.previousEntry();
        Assertions.assertEquals(3,menu.getCurrentEntry());
    }

    @Test
    public void getEntry(){
        Assertions.assertEquals("Entry3",menu.getEntry(2));
    }

    @Test
    public void isSelectedTrue(){
        Assertions.assertEquals(true,menu.isSelected(0));
    }

    @Test
    public void isSelectedFalse(){
        menu.setCurrentEntry(2);
        Assertions.assertEquals(false,menu.isSelected(0));
    }

    @Test
    public void isSelectedExit(){
        menu.setCurrentEntry(3);
        Assertions.assertEquals(true,menu.isSelectedExit());
    }
}
