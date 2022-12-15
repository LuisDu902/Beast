package org.l06gr06.model.menu;

import java.util.Arrays;
import java.util.List;

public class ScoreMenu extends Menu{
    private final long[] stats;

    public ScoreMenu(long[] stats){
        entries = Arrays.asList("Play Again", "ScoreBoard", "Exit");
        this.stats = stats;
    }
    public boolean isSelectedPlayAgain(){
        return isSelected(0);
    }

    public boolean isSelectedScoreBoard() { return isSelected(1);}

    public long[] getStats() {
        return stats;
    }

}
