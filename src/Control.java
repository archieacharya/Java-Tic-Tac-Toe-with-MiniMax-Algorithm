/**
 * Control module runs the whole game
 * @author Bolin Chen
 *
 */

public class Control {
	
	public static final char HUMAN = 'X';
	public static final char AI = 'O';
	
	private int gameOver = -1;
	
	/**
	 * Default constructor, generate a new game, game ends when the gameOver number is not -1
	 */
	public Control(int start)
	{
		Model Game = new Model();
		char turn;
		if(start == 0)
			turn = HUMAN;
		else
			turn = AI;
		while(gameOver == -1)
		{
			View.display(Game.getBoard());
			
			if(turn == HUMAN)
			{
				System.out.println("X Turn");
				Game.HumanMove();
				turn = AI;
			}
			else
			{
				System.out.println("O Turn");
				MiniMax.AI_Move(Game, 1);
				turn = HUMAN;
			}
			
			gameOver = View.checkWinner(Game.getBoard());
		}
		
		View.display(Game.getBoard());
		
		System.out.println();
		if(gameOver != -1)
		{
			if(gameOver == 0)
				System.out.println("You Win");
			else if(gameOver == 1)
				System.out.println("Computer Win");
			else if(gameOver == 2)
				System.out.println("Tie");
			System.exit(0);
		}
	}
}
