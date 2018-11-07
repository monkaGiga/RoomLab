package Rooms;

import Game.Runner;
import People.Person;

import java.util.Scanner;

public class WinningRoom extends Room
{

	public WinningRoom(int x, int y) {
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
		System.out.println("You found a way down, would you like to go deeper? ");
		Scanner input = new Scanner(System.in);
		String deep = input.nextLine ();
		if(deep.equals("yes"))
		{
			Runner.newMap(x);
		}
	}

	

}
