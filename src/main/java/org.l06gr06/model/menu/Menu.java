package org.l06gr06.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> entries ;
    private int currentEntry;

    public Menu(List<String> entries){
        this.entries = entries;
    }
    public void nextEntry(){
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }
    public void previousEntry(){
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }
    public String getEntry(int i){
        return entries.get(i);
    }
    public boolean isSelected(int i){
        return currentEntry == i;
    }
    public int getNumberEntries(){
        return this.entries.size();
    }
    public boolean isSelectedExit(){
        return isSelected(entries.size()-1);
    }
}
