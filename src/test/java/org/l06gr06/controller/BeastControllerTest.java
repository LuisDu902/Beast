package org.l06gr06.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.controller.game.BeastController;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.game.elements.Beast;
import org.l06gr06.model.game.elements.Player;
import org.l06gr06.model.game.elements.PowerUp;
import org.l06gr06.model.game.elements.Wall;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BeastControllerTest {
    private BeastController controller;
    private Beast egg;
    private Beast beast;
    private Beast strongerBeast;
    private List<PowerUp> powerUps;
    private Arena arena;
    private Player player;


    @BeforeEach
    void setUp() {
        arena = new Arena(20, 20);

        egg = new Beast(1,1,0);

        beast = new Beast(10, 10,1);

        strongerBeast = new Beast(15,15,2);

        player = new Player(5,5);

        List<Wall> walls = new ArrayList<>();
        this.powerUps = new ArrayList<>();
        List<Beast> beasts = new ArrayList<>();

        beasts.add(egg);
        beasts.add(beast);
        beasts.add(strongerBeast);

        arena.setPlayer(player);
        arena.setWalls(walls);

        arena.setPowerUps(powerUps);
        arena.setBlocks(new ArrayList<>());
        arena.setBeasts(beasts);

        controller = new BeastController(arena);
    }

    @Test
    void hatchEgg() throws IOException{
        controller.step(null, GUI.ACTION.UP, arena.getStartingTime()+10000);
        Assertions.assertEquals(1, egg.getPhase());
    }

    @Test
    void speedUp() throws IOException {
        for (int i = 14; i <= 16; i++){
            powerUps.add(new PowerUp(i,14));
            powerUps.add(new PowerUp(i,16));
        }
        powerUps.add(new PowerUp(14,15));
        powerUps.add(new PowerUp(16,15));
        controller.step(null,GUI.ACTION.UP, controller.getSpeed()+1);
        Assertions.assertEquals(450, controller.getSpeed());
    }
    @Test
    void evolve() throws IOException {
        for (int i = 9; i <= 11; i++){
            powerUps.add(new PowerUp(i,9));
            powerUps.add(new PowerUp(i,11));
        }
        powerUps.add(new PowerUp(9,10));
        powerUps.add(new PowerUp(11,10));
        controller.step(null,GUI.ACTION.UP, controller.getSpeed()+1);
        Assertions.assertEquals(2,beast.getPhase());
    }

    @Test
    void hitImmortalPLayer() throws IOException {
        arena.setBeasts(Arrays.asList(new Beast(5,4,1),
                new Beast(5,6,1),
                new Beast(4,4,1),
                new Beast(4,5,1),
                new Beast(4,6,1),
                new Beast(6,4,1),
                new Beast(6,5,1),
                new Beast(6,6,1)
        ));
        player.becomeImmortal();
        controller.step(null,GUI.ACTION.DOWN, controller.getSpeed()+1);
        Assertions.assertEquals(0,player.getPhase());
    }
    @Test
    void hitNormalPLayer() throws IOException {

        arena.setBeasts(Arrays.asList(new Beast(5,4,1),
                new Beast(5,6,1),
                new Beast(4,4,1),
                new Beast(4,5,1),
                new Beast(4,6,1),
                new Beast(6,4,1),
                new Beast(6,5,1),
                new Beast(6,6,1)
        ));
        controller.step(null,GUI.ACTION.UP, controller.getSpeed()+1);
        Assertions.assertEquals(4,player.getLife());
    }
}
