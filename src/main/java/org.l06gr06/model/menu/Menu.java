package org.l06gr06.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {
    protected List<String> entries ;
    protected int currentEntry;

    public Menu() {
        this.entries = Arrays.asList();
    }
    public Menu(List<String> entries){
        this.entries = entries;
    }

    public int getCurrentEntry(){
        return currentEntry;
    }
    public void setCurrentEntry(int i){
        if (i < entries.size()){
            currentEntry = i;
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        int i = 0;
        for (String entry : entries){
            if (!entry.equals(menu.getEntry(i))) return false;
            i++;
        }
        return true;
    }
}
