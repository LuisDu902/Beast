package org.l06gr06.model.menu;

import java.util.Arrays;
import java.util.List;

public class MainMenu extends Menu{
    public MainMenu(){
        entries = Arrays.asList("[Press enter to play]");
    }
    public MainMenu(List<String> entries){
        this.entries = entries;
    }
}
