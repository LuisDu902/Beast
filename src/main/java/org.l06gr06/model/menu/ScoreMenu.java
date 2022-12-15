package org.l06gr06.model.menu;

import java.util.List;

public class ScoreMenu extends Menu{
    private long[] stats;
    public ScoreMenu(List<String> entries, long[] stats){
        super(entries);
        this.stats = stats;
    }
    public boolean isSelectedPlayAgain(){
        return isSelected(0);
    }

    public long[] getStats() {
        return stats;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreMenu scoreMenu = (ScoreMenu) o;
        int i = 0;
        for (String entry : entries) {

            if (!entry.equals(scoreMenu.getEntry(i))) return false;
            i++;
        }
        return true;
    }
}
