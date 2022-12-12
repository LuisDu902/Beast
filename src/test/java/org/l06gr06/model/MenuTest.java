package org.l06gr06.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.l06gr06.model.menu.MainMenu;
import org.l06gr06.model.menu.Menu;
import org.l06gr06.model.menu.ScoreMenu;

import java.util.Arrays;

public class MenuTest {
    Menu menu;
    @Test
    public void mainMenu(){
        MainMenu mainMenu = new MainMenu(Arrays.asList("Entry1","Entry2","Entry3","Exit"));
        Assertions.assertTrue(mainMenu.isSelectedStart());
    }

    @Test
    public void scoreMenu(){
        ScoreMenu scoreMenu = new ScoreMenu(Arrays.asList("Entry1","Entry2","Entry3","Exit"));
        Assertions.assertTrue(scoreMenu.isSelectedPlayAgain());
    }

    @BeforeEach
    public void helper(){
        menu = new Menu(Arrays.asList("Entry1","Entry2","Entry3","Exit"));
    }

    @Test
    public void nextEntry(){
        menu.nextEntry();
        Assertions.assertEquals(1,menu.getCurrentEntry());
        menu.setCurrentEntry(3);
        menu.nextEntry();
        Assertions.assertEquals(0,menu.getCurrentEntry());
    }

    @Test
    public void previousEntry(){
        menu.setCurrentEntry(3);
        menu.previousEntry();
        Assertions.assertEquals(2,menu.getCurrentEntry());
        menu.setCurrentEntry(0);
        menu.previousEntry();
        Assertions.assertEquals(3,menu.getCurrentEntry());
    }


    @Test
    public void getEntry(){
        Assertions.assertEquals("Entry3",menu.getEntry(2));
    }

    @Test
    public void isSelectedTrue(){
        Assertions.assertTrue(menu.isSelected(0));
        menu.setCurrentEntry(2);
        Assertions.assertFalse(menu.isSelected(0));
    }

    @Test
    public void isSelectedExit(){
        menu.setCurrentEntry(3);
        Assertions.assertTrue(menu.isSelectedExit());
    }
}
