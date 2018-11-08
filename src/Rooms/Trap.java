package Rooms;

import Game.Runner;
import People.Person;

import java.util.Random;
import java.util.Scanner;


public class Trap extends Room
{
    public Trap(int x, int y) {
        super(x, y);

    }

    /**
     * Triggers the game ending conditions.
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x) {

        occupant = x;
        x.trapCheck = true;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);

    }
}