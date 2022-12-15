package org.l06gr06.model.menu;

import java.util.List;

public class MainMenu extends Menu{
    public MainMenu(List<String> entries){
        super(entries);
    }
    public boolean isSelectedStart(){
        return isSelected(0);
    }
}
