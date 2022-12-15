package org.l06gr06.model.menu;

import java.util.List;

public class ScoreBoardMenu extends Menu{
    public ScoreBoardMenu(List<String> entries){
        super(entries);
    }
    public boolean isSelectedPlayAgain(){
        return isSelected(0);
    }

}
