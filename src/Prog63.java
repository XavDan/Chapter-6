/* Xavier Danilchenko 
 * 11/21/2016
 * Both the projects combined
 */
import java.util.Scanner;
public class Prog63
{


	public static void main(String[] args) 
	{
		Scanner whichgame = new Scanner(System.in);
		String game;
		int gamerino = 0;
		do {
			System.out.println("Would you like to play 1) Guess a number or 2) Slot machine?");
			game = whichgame.next();

			try {
				gamerino =  Integer.parseInt(game);
			} catch(NumberFormatException e) {
				System.out.println("EXCEPTION! Non-numeric input: " + e.getMessage());
			}
			
			if (gamerino == 1)
			{
				guessing();
				return;
			}
			else if(gamerino == 2)
			{
				slotmachine();
				return;
			} else {
				System.out.println("Invalid selection, please try again");
			}
		} while (true);
	}
	//The guessing game
	public static void guessing() 
	{
		System.out.println("Please enter a number between 1 and 100.");
		mainGuess();
	}
	
	public static int mainGuess()
	{
		Scanner userGuessing = new Scanner(System.in);
		//String guesserino;
		1
		//guesserino = userGuessing.next();
		//int guessed= Integer.parseInt(guesserino);
		int guessed = 0;
		int random = (int)(Math.random() * 100 + 1);
		
		do {
			try{
				guessed = userGuessing.nextInt();
				if (guessed == random)
				{
					ifCorrect();
				} else 	if ((guessed > 100) || (guessed <= 0))
				{
					System.out.println("Entry out of bounds. Please enter a number between 1 and 100.");
				}
				else if (guessed < random)
				{
					ifLower();
				}
				else if (guessed > random)
				{
					ifHigher();
				}
			}
			catch(Exception e) {
				System.out.println("EXCEPTION! Non-numeric input. Please try again.");
				userGuessing.nextLine(); // To force the scanner past the bad input
			}
		} while (guessed != random);
		return guessed;
	}
	
	public static void ifLower()
	{
		System.out.println("Guess higher.");
	}
	public static void ifHigher()
	{
		System.out.println("Guess lower.");
	}
	public static void ifCorrect()
	{
		Scanner userImput = new Scanner(System.in);
		System.out.println("YOU GOT IT!");
		System.out.println("Would you like to 1) continue playing the guessing game oe 2) play the slot machine?");
		int ans = userImput.nextInt();
		
		
			if(ans == 1)
			{
				System.out.println("Please enter a number between 1 and 100.");
				mainGuess();
			}
			else if(ans == 2)
			{
				slotmachine();
			}
			else
			{
				System.out.println("Please enter 1 or 2.");
				ans = userImput.nextInt();
			}
	}
	//The slot machine
	public static void slotmachine() 
	{
		Scanner playerInput = new Scanner(System.in);
		int playerMoney;
		playerMoney = 10;
		prompt(playerMoney);
			


	}
	
	
	public static void prompt(int money)
	{
		
		Scanner playerInputerino = new Scanner(System.in);
		System.out.println("You have $" + money + ".\nPress \"p\" to play the slots!");
		money = money - 1;
		String userAnswerino = playerInputerino.next();
		while(userAnswerino == userAnswerino)
		if(userAnswerino.equals("p"))
		{
			
			slots(money);
			
		}
		else if(userAnswerino != "p")
		{
			System.out.println("Press \"p\" to play the slots!");
			userAnswerino = playerInputerino.next();
		}
	
		
	}
	public static void slots(int money)
	{
		
		int slotOne = (int)(Math.random() * 9 + 1);
		int slotTwo = (int)(Math.random() * 9 + 1);
		int slotThree = (int)(Math.random() * 9 + 1);
		System.out.println(slotOne + "\t" + slotTwo + "\t" + slotThree);
		if(slotOne == slotTwo || slotTwo == slotThree || slotOne == slotThree)
		{
			System.out.println("You have won $3!");
			money = money + 3;
		}
		else if (slotOne == slotTwo && slotTwo == slotThree && slotOne == slotThree)
		{
			System.out.println("Woohoo! You won $10!");
			money = money + 10;
		}
		else if(money == 0)
		{
			System.out.print("You are out of money. Sorry! Would you like to 1) Continue playing the " 
								+ "slot machine or 2) play the guessing game?");
			Scanner userchoice = new Scanner(System.in);
			int choicerino;
			choicerino = userchoice.nextInt();
			if(choicerino == 1)
			{
				slotmachine();
			}
			else if(choicerino == 2)
			{
				guessing();
			}
		}
		else
		{
			System.out.println("You didn't match any numbers.");
		}
		
		prompt(money);
		
	}
//(int)(Math.random() * 100 + 1)
//testerino.= ".*[a-zA-Z]*."


}
