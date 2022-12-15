package org.l06gr06.model.menu;

import java.util.List;

public class ScoreBoardMenu extends Menu{
    public ScoreBoardMenu(List<String> entries){
        super(entries);
    }
    public boolean isSelectedPlayAgain(){
        return isSelected(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreBoardMenu scoreBoardMenu = (ScoreBoardMenu) o;
        int i = 0;
        for (String entry : entries) {

            if (!entry.equals(scoreBoardMenu.getEntry(i))) return false;
            i++;
        }
        return true;
    }
}
