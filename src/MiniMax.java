/**
 * MiniMax module give Computer side decision making by using MiniMax algorithm
 * @author Bolin Chen
 *
 */
public class MiniMax {

	/**
	 * MiniMax Algorithm, return each node score
	 * @param model input Model module
	 * @param side player side
	 * @return evaluation function score
	 */
	public static double AI_Move(Model model, int side)
	{
		if(View.checkWinner(model.getBoard()) != -1)
		{
			return evaluate(side, model);
		}
		if(side == 1)
			return MaxScore(side, model);
		else
			return MinScore(side, model);
	}
	
	/**
	 * MaxScore return max score in the node
	 * @param side player side
	 * @param model input Model module
	 * @return Max score for all current nodes
	 */
	private static double MaxScore(int side, Model model)
	{
		double bestScore = Double.NEGATIVE_INFINITY;
		int BestMove_Index = -1;
		for(Integer Move : model.getAvail_Move())
		{
			Model Copy_Board = model.CopyBoard();
			Copy_Board.HashMove(Move, side);
			double score = AI_Move(Copy_Board, 0);
			
			if(score >= bestScore)
			{
				bestScore = score;
				BestMove_Index = Move;
			}
		}
		
		model.HashMove(BestMove_Index, side);
		
		return bestScore;
	}
	
	/**
	 * MinScore return smallest score in the node
	 * @param side player side
	 * @param model input Model module
	 * @return Small score for all current nodes
	 */
	private static double MinScore(int side, Model model)
	{
		double bestScore = Double.POSITIVE_INFINITY;
		int BestMove_Index = -1;
		for(Integer Move : model.getAvail_Move())
		{
			Model Copy_Board = model.CopyBoard();
			Copy_Board.HashMove(Move, side);
			double score = AI_Move(Copy_Board, 1);
			
			if(score <= bestScore)
			{
				bestScore = score;
				BestMove_Index = Move;
			}
		}
		
		model.HashMove(BestMove_Index, side);
		
		return bestScore;
	}
	
	/**
	 * Evaluate function, if Computer wins return 20, if Human wins return -20, otherwise return 0
	 * @param side player side
	 * @param model input Model module
	 * @return evaluate score
	 */
	private static double evaluate(int side, Model model)
	{
		if(View.checkWinner(model.getBoard()) == 1)
		{
			return 20;
		}
		else if(View.checkWinner(model.getBoard()) == 0)
		{
			return -20;
		}
		else
			return 0;
	}
}
