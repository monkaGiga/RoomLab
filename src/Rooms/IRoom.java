package Rooms;

import Game.Runner;
import People.Person;
import Items.Idol;
import Items.Artifact;
import Items.Map;
import Items.Torch;

public class IRoom extends Room
{

    public IRoom(int x, int y) {
        super(x, y);

    }

    /**
     * Triggers the game ending conditions.
     * @param x the Person entering
     */
    @Override
    public void enterRoom(Person x) {

        occupant = x;
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
        System.out.println("You found the item room");
        double itemNum = (Math.random()*25);
        /*
        if (itemNum == 1)
        {
            int item = Torch;
            System.out.println("You found a" + item);
        }
        if (itemNum == 10)
        {
            int item = Map;
            System.out.println("You found a" + item);
        }
        if (itemNum == 20)
        {
            int item = Idol;
            System.out.println("You found an" + item);
        }
        else
        {
            int item = Artifact;
            System.out.println("You found an" + item);
        }
    }*/


}}
