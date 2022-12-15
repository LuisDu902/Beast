package org.l06gr06.model.menu;

import org.l06gr06.model.game.arena.Arena;

import java.util.List;

public class LevelMenu extends Menu{
    public LevelMenu(List<String> entries){
        super(entries);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LevelMenu levelMenu = (LevelMenu) o;
        int i = 0;
        for (String entry : entries){

            if (! entry.equals(levelMenu.getEntry(i))) return false;
            i++;
        }
       return true;
    }
}
