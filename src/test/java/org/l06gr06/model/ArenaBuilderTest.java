package org.l06gr06.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.game.arena.RandomArenaBuilder;

public class ArenaBuilderTest {

    @Test
    public void createArena(){
        RandomArenaBuilder arenaBuilder = new RandomArenaBuilder(20,20,3,6, 5,10);
        Arena arena = arenaBuilder.createArena();
        Assertions.assertEquals(20,arena.getWidth());
        Assertions.assertEquals(20,arena.getHeight());
        Assertions.assertEquals(3 + 5,arena.getBeasts().size());
        Assertions.assertEquals(6,arena.getBlocks().size());
        int expected_walls = (arena.getWidth()*2 + (arena.getHeight())*2 -4);
        Assertions.assertEquals(expected_walls,arena.getWalls().size());
    }

}
