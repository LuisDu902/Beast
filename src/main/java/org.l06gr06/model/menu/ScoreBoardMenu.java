package org.l06gr06.model.menu;

import java.util.Arrays;
import java.util.List;

public class ScoreBoardMenu extends Menu{
    public ScoreBoardMenu(){
        entries = Arrays.asList("Play again", "Exit");
    }
    public boolean isSelectedPlayAgain(){
        return isSelected(0);
    }
}
