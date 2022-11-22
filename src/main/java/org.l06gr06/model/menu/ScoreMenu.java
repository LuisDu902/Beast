package org.l06gr06.model.menu;

import java.util.List;

public class ScoreMenu extends Menu{
    public ScoreMenu(List<String> entries){
        super(entries);
    }
    public boolean isSelectedPlayAgain(){
        return isSelected(0);
    }
}
