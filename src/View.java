/**
 * View module contains static method
 * @author Bolin Chen
 *
 */

public class View {
	
	/**
	 * display method print the given game board to console
	 * @param board input game board
	 */
	public static void display(char[][] board)
	{
		for(int i = 0; i <= board.length * 2; i++)
		{
			for(int j = 0; j <= board[0].length * 4; j++)
			{
				if(i % 2 != 0)
				{
					if(j % 2 == 0 && j % 4 != 0 && j != 0 && j != board[0].length * 4)
						System.out.print(board[(i - 1) / 2][(j - 2) / 4]);
					else if(j % 4 == 0)
						System.out.print('|');
					else
						System.out.print(' ');
				}
				else
				{
					if(j % 4 == 0 || j == 0 || j == board[0].length * 4)
						System.out.print('+');
					else
						System.out.print('-');
				}
			}
			System.out.println();
		}
	}
	
	/**
	 * CheckWinner method generate winning status from given game board.
	 * @param board input game board
	 * @return 0 represents X win, 1 represents O win, 2 represents tie, -1 represents the game is not over yet
	 */
	public static int checkWinner(char[][] board)
	{
		for(int row = 0; row < board.length; row++)
		{
			if(board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][0] != ' ')
			{
				if(board[row][0] == 'X')
					return 0;
				else
					return 1;
			}
		}
		
		for(int col = 0; col < board.length; col++)
		{
			if(board[0][col] == board[1][col] && board[1][col] == board[2][col] && board[0][col] != ' ')
			{
				if(board[0][col] == 'X')
					return 0;
				else
					return 1;
			}
		}
		
		if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ')
		{
			if(board[0][0] == 'X')
				return 0;
			else
				return 1;
		}
		if(board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != ' ')
		{
			if(board[2][0] == 'X')
				return 0;
			else
				return 1;
		}
		
		for(int i = 0; i < board.length; i++)
		{
			for(int j = 0; j < board.length; j++)
			{
				if(board[i][j] == ' ')
					return -1;
			}
		}
	
		return 2;
	}

}
