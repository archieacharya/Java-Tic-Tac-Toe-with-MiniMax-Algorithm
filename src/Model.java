import java.util.*;

/**
 * Model module generates the game board
 * @author Bolin Chen
 *
 */

public class Model 
{
	private char[][] board;
	private ArrayList<Integer> availa_move;
	
	/**
	 * default constructor, generate 3 X 3 char[][] board and an Arraylist of all available moves
	 */
	public Model()
	{ 
		board = new char[3][3];
		availa_move = new ArrayList<Integer>();
		for(int i = 0; i < board.length; i++)
			for(int j = 0; j < board[0].length; j++)
				board[i][j] = ' ';
		for(int i = 0; i < board.length * board[0].length; i++)
		{
			availa_move.add(i);
		}
	}
	
	/**
	 * Output current game board
	 * @return char[][] game board
	 */
	public char[][] getBoard()
	{
		return board;
	}
	
	/**
	 * Output all current available moves
	 * @return all available moves
	 */
	public ArrayList<Integer> getAvail_Move()
	{
		return availa_move;
	}
	
	/**
	 * For player, validate input for make move
	 * @param in System.in
	 * @param side player side
	 * @return int for row or col
	 */
	public int readInput(Scanner in, String side)
	{
		int cor = -1;
		do
		{
			
				if(in.hasNextInt())
				{
					cor = in.nextInt();
					break;
				}
				else
				{
					System.out.println("Invalid Input: Not an int");
					in.next();
					System.out.println("Enter the " + side + ": ");
				}
			
		}
		while(in.hasNext());
		return cor;
	}
	
	/**
	 * Transform int side to char side, 0 represents player X, 1 represents player O
	 * @param side int side
	 * @return char that represents current side
	 */
	public static char current_turn(int side)
	{
		if(side == 0)
		{
			return 'X';
		}
		else
		{
			return 'O';
		}
	}
	
	/**
	 * make valid move on game board and remove available move from availa_move
	 * @param row input row
	 * @param col input col
	 * @param side player side
	 */
	public void MakeMove(int row, int col, int side)
	{
		board[row][col] = Model.current_turn(side);
		availa_move.remove(Integer.valueOf(row * board.length + col));
	}
	
	/**
	 * calculate move from stored availa_move index 
	 * @param index index from availa_move, index / 3 represents row, index % 3 represents col
	 * @param side player side
	 */
	public void HashMove(int index, int side)
	{
		MakeMove(index / 3, index % 3, side);
	}
	
	/**
	 * Copy the current Model
	 * @return new Model copied from current Model
	 */
	public Model CopyBoard()
	{
		Model NewBoard = new Model();
		for(int i = 0; i < 3; i++)
		{
			NewBoard.board[i] = this.board[i].clone();
		}
		NewBoard.availa_move = new ArrayList<Integer>();
		NewBoard.availa_move.addAll(this.availa_move);
		return NewBoard;
	}
	
	/**
	 * User move from Scanner in
	 */
	public void HumanMove()
	{

		Scanner in = new Scanner(System.in);
		boolean validInput = false;
		do 
		{
			System.out.println("Enter the Row: ");
			int row = readInput(in, "Row");
			System.out.println("Enter the Col: ");
			int col = readInput(in, "Col");

			if(row > 0 && col > 0 && row < 4 && col < 4)
			{
				if(board[row - 1][col - 1] == ' ')
				{
					MakeMove(row - 1, col - 1, 0);
					validInput = true;
				}
				else
				{
					System.out.println("Invalid Input: Cell already be token");
					System.out.println("X Turn");
				}
			}
			else
			{
				System.out.println("Invalid Input: Input out of range, the input range should be 1 - 3");
				System.out.println("X Turn");
			}
		}while(!validInput);
	}

}
	

