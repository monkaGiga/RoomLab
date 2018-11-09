package Game;

import People.Person;
import Rooms.Death;
import Rooms.Room;
import Rooms.IRoom;
import Rooms.WinningRoom;
import Rooms.Trap;


import java.util.Scanner;

public class Runner {
	

	private static boolean gameOn = true;
	static int x1,y1;
	public static void main(String[] args)
	{
		Room[][] building = new Room[5][5];
		
		//Fill the building with normal rooms
		for (int x = 0; x<building.length; x++)
		{
			for (int y = 0; y < building[x].length; y++)
			{
				building[x][y] = new Room(x,y);
			}
		}
		
		//Create a random winning room.
		int x = (int)(Math.random()*building.length);
		int y = (int)(Math.random()*building.length);
		building[x][y] = new WinningRoom(x, y);
		//Create a room where you die
		double droom = (Math.random()*10);
		if(droom >= 9) {
			 x1 = (int) (Math.random() * building.length);
			 y1 = (int) (Math.random() * building.length);
			building[x1][y1] = new Death(x1, y1);
		}
		else
		{
			 x1 = (int) (Math.random() * building.length);
			 y1 = (int) (Math.random() * building.length);
			building[x1][y1] = new Trap(x1, y1);
		}
		int x2 = (int)(Math.random()*building.length);
		int y2 = (int)(Math.random()*building.length);
		building[x2][y2] = new IRoom(x2, y2);
		 
		 //Setup player 1 and the input scanner
		Person player1 = new Person("FirstName", "FamilyName", 0,0);
		System.out.println("Welcome to the Never Ending Cave");
		building[0][0].enterRoom(player1);
		Scanner in = new Scanner(System.in);
		while(gameOn)
		{
			if (player1.trapCheck == true)
			{

				System.out.println("You enter a trapped room, the doorway behind you shuts");
				System.out.println("You see three idols in front of you, a plaque reads");
				System.out.println("PICK ONE(1,2,3)");
				int guess = in.nextInt();

				int traCount = (int)(Math.random()*3);
				if (traCount == 0) {

					int death = 1;
					int none = 2;
					int points = 3;

					if (guess == death) {
						System.out.println("As you pick up the idol you hear clicks, the last thing you see is the ceiling falling");
						Runner.gameOff();


					}
					if (guess == none) {
						System.out.println("As you pick it up all the idols crumble into dust and the doorway reopens");
						player1.trapCheck = false;
						building[x1][y1] = new Room(x1,y1);

					}
					if (guess == points) {
						System.out.println("As you pick it up the other 2 idols crumble, you decide to keep this idol because it is shiny");
						player1.trapCheck = false;
						building[x1][y1] = new Room(x1,y1);

					}
				}
				if (traCount == 1) {
					int death = 3;
					int none = 1;
					int points = 2;

					if (guess == death) {
						System.out.println("As you pick up the idol you hear clicks, the last thing you see is the ceiling falling");
						Runner.gameOff();

					}
					if (guess == none) {
						System.out.println("All the idols crumble into dust and the doorway reopens");
						player1.trapCheck = false;
						building[x1][y1] = new Room(x1,y1);

					}
					if (guess == points) {
						System.out.println("As you pick it up the other 2 idols crumble, you decide to keep this idol because it is shiny");
						player1.trapCheck = false;
						building[x1][y1] = new Room(x1,y1);

					}
				}
				if (traCount == 2) {
					int death = 2;
					int none = 3;
					int points = 1;

					if (guess == death) {
						System.out.println("As you pick up the idol you hear clicks, the last thing you see is the ceiling falling");
						Runner.gameOff();

					}
					if (guess == none) {
						System.out.println("All the idols crumble into dust and the doorway reopens");
						player1.trapCheck = false;
						building[x1][y1] = new Room(x1,y1);

					}
					if (guess == points) {
						System.out.println("As you pick it up the other 2 idols crumble, you decide to keep this idol because it is shiny");
						player1.trapCheck = false;
						building[x1][y1] = new Room(x1,y1);
					}
				}
			}
			else {
				System.out.println("Where would you like to move? (Choose W, A, S, D)");
				String move = in.nextLine();
				if (validMove(move, player1, building)) {
					System.out.println("Your coordinates: row = " + player1.getxLoc() + " col = " + player1.getyLoc());

				} else {
					System.out.println("Please choose a valid move.");
				}
			}
			
			
		}
		in.close();
	}

	/**
	 * Checks that the movement chosen is within the valid game map.
	 * @param move the move chosen
	 * @param p person moving
	 * @param map the 2D array of rooms
	 * @return
	 */
	public static boolean validMove(String move, Person p, Room[][] map)
	{
		move = move.toLowerCase().trim();
		switch (move) {
			case "w":
				if (p.getxLoc() > 0)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()-1][p.getyLoc()].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}
			case "d":
				if (p.getyLoc()< map[p.getyLoc()].length -1)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc() + 1].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}

			case "s":
				if (p.getxLoc() < map.length - 1)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()+1][p.getyLoc()].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}

			case "a":
				if (p.getyLoc() > 0)
				{
					map[p.getxLoc()][p.getyLoc()].leaveRoom(p);
					map[p.getxLoc()][p.getyLoc()-1].enterRoom(p);
					return true;
				}
				else
				{
					return false;
				}
			default:
				break;
					
		}
		return true;
	}

	public static void gameOff()
	{
		gameOn = false;
	}
	public static void newMap(Person peo)
	{
		Room[][] building = new Room[5][5];

		//Fill the building with normal rooms
		for (int x = 0; x<building.length; x++)
		{
			for (int y = 0; y < building[x].length; y++)
			{
				building[x][y] = new Room(x,y);
			}
		}

		//Create a random winning room.
		int x = (int)(Math.random()*building.length);
		int y = (int)(Math.random()*building.length);
		building[x][y] = new WinningRoom(x, y);
		//Create a room where you die
		int x1 = (int)(Math.random()*building.length);
		int y1 = (int)(Math.random()*building.length);
		building[x1][y1] = new Death(x1, y1);
		int x2 = (int)(Math.random()*building.length);
		int y2 = (int)(Math.random()*building.length);
		building[x2][y2] = new IRoom(x2, y2);
		building[0][0].enterRoom(peo);
		//make a chance there will be instadeath room, not 100%
		//if not instadeath guess make it a 1/3 death room,
		//player guesses rgb buttons and if you press the wrong button
		//you die with torch on map it is disguised as a item room because it has idol
	}


}
