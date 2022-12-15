package org.l06gr06.model.menu;

import java.util.List;

public class ScoreMenu extends Menu{
    private final long[] stats;

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

}
