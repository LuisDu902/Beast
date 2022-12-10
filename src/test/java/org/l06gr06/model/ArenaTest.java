package org.l06gr06.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.game.elements.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArenaTest {
    Arena arena;

    @BeforeEach
    public void setArena(){
        arena = new Arena(10,10);
    }

    @Test
    public void findBlock(){
        Block foundBlock = new Block(5,3);
        arena.setBlocks(Arrays.asList(new Block(1,1),new Block(1,2),foundBlock,new Block(2,3)));
        Assertions.assertEquals(foundBlock,arena.findBlock(new Position(5,3)));
        Assertions.assertNull(arena.findBlock(new Position(4,4)));
    }


   @Test
    public void findBeast(){
        arena.setBeasts(Arrays.asList(new Beast(1,2,0), new Beast(2,2,2), new Beast(3,3,1)));
        Assertions.assertEquals(1, arena.findBeast(new Position(2,2)));
        Assertions.assertEquals(-1, arena.findBeast(new Position(3,2)));
   }

   @Test
    public void findPowerUp(){
        arena.setPowerUps(Arrays.asList(new Heart(1,2),new Shield(4,4),new PowerUp(7,3), new Heart(9,4)));
        Assertions.assertEquals(3,arena.findPowerUp(new Position(9,4)));
        Assertions.assertEquals(-1,arena.findPowerUp(new Position(5,4)));
   }

    @Test
    public void isEgg(){
        arena.setBeasts(Arrays.asList(new Beast(1,1,2), new Beast(2,2,1),new Beast(3,3,0)));
        Assertions.assertTrue(arena.isEgg(new Position(3,3)));
        Assertions.assertFalse(arena.isEgg(new Position(1,1)));
        Assertions.assertFalse(arena.isEgg(new Position(4,4)));
    }

    @Test
    public void isBeast(){
        arena.setBeasts(Arrays.asList(new Beast(1,1,2), new Beast(2,2,1),new Beast(3,3,0)));
        Assertions.assertTrue(arena.isBeast(new Position(1,1)));
        Assertions.assertTrue(arena.isBeast(new Position(3,3)));
        Assertions.assertFalse(arena.isBeast(new Position(4,4)));
    }

    @Test
    public void isWall(){
        arena.setWalls(Arrays.asList(new Wall(1,1), new Wall(2,2),new Wall(3,3)));
        Assertions.assertTrue(arena.isWall(new Position(3,3)));
        Assertions.assertTrue(arena.isWall(new Position(1,1)));
        Assertions.assertFalse(arena.isWall(new Position(4,4)));
    }

    @Test
    public void isBlock(){
        arena.setBlocks(Arrays.asList(new Block(1,1), new Block(2,2),new Block(3,3)));
        Assertions.assertTrue(arena.isBlock(new Position(3,3)));
        Assertions.assertTrue(arena.isBlock(new Position(1,1)));
        Assertions.assertFalse(arena.isBlock(new Position(4,4)));
    }

    @Test
    public void isPowerUp(){
        arena.setPowerUps(Arrays.asList(new PowerUp(1,1), new Heart(2,2),new Shield(3,3)));
        Assertions.assertTrue(arena.isPowerUp(new Position(3,3)));
        Assertions.assertTrue(arena.isPowerUp(new Position(2,2)));
        Assertions.assertTrue(arena.isPowerUp(new Position(1,1)));
        Assertions.assertFalse(arena.isPowerUp(new Position(4,4)));
    }

    @Test
    public void isEmpty(){
        arena.setBeasts(new ArrayList<>());
        arena.setWalls(new ArrayList<>());
        arena.setBlocks(new ArrayList<>());
        for (int i = 0; i <= 10; i++){
            for (int j = 0; j <= 10; j++){
                Assertions.assertTrue(arena.isEmpty(new Position(i,j)));
            }
        }
    }

    @Test
    public void hatchEggs(){
        arena.setBeasts(Arrays.asList(new Beast(1,1,0), new Beast(2,2,1),
                new Beast(3,3,0), new Beast(2,4,1)));
        arena.hatchEggs();
        for (Beast beast : arena.getBeasts()){
            Assertions.assertTrue(beast.getPhase() != 0);
        }
    }

    @Test
    public void CreatePowerUp(){
        arena.setBeasts(new ArrayList<>());
        arena.setWalls(new ArrayList<>());
        arena.setBlocks(new ArrayList<>());
        arena.setPowerUps(new ArrayList<>());
        arena.createPowerUp();
        Assertions.assertEquals(1,arena.getPowerUps().size());
        arena.createPowerUp();
        Assertions.assertEquals(2,arena.getPowerUps().size());
        arena.createPowerUp();
        Assertions.assertEquals(3,arena.getPowerUps().size());
        for (PowerUp powerUp : arena.getPowerUps()){
            Assertions.assertTrue(powerUp.getPosition().getX() > 0
                    && powerUp.getPosition().getX() < arena.getWidth()
                    && powerUp.getPosition().getY() < arena.getHeight()
                    && powerUp.getPosition().getY() > 0 );
        }
    }
}
