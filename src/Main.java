import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Main module starts the game
 * @author Bolin Chen
 */

public class Main {
	
	/**
	 * print the menu
	 */
	public void display_menu()
	{
		System.out.println("1 Start Game with Player First");
		System.out.println("2 Start Game with Computer First");
		System.out.println("3 Exit Game");
		System.out.print("Selection: ");
		
	}
	
	/**
	 * default constructor, print welcome message, validate users input
	 * @throws InputMismatchException Throw Exception if input is not an int
	 */
	public Main() throws InputMismatchException
	{
		System.out.println("Welcome To Tic Tac Toe");
		System.out.println("The Game Board is 3 X 3, you hold X, computer holds O");
		Scanner in = new Scanner(System.in);
		
		display_menu();
		while(true)
		{
			try
			{
				switch(in.nextInt())
				{
					case 1:
						Control newGame = new Control(0);
						break;
					case 2:
						Control newGame2 = new Control(1);
						break;
					case 3:
						in.close();
						System.exit(0);
						break;
					default:
						System.out.println("Invalid Input");
						display_menu();
                    		break;
				}
			}
			catch(java.util.InputMismatchException err)
			{
				System.out.println("\nINVALID INPUT!");
				display_menu();
				in.next();
			}
		}
		
	}

	/**
	 * run the program
	 * @param args args not used
	 */
	public static void main(String[] args) {
		
		new Main();

	}

}
