package exploration1;

public class Environment {

	public static int width = 50;
	public static int height = 50;
	
	
	//0 is for obstacle, 1 is for searchable grid
	private int[][] board = new int [width][height]; 
	
	public Environment(){
		for(int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[i].length; j++)
			{
				if((i == 0) || (i == width -1)||(j ==0)||(j == height -1))
					board[i][j] = 1;
				else
					board[i][j] = 0;
				
//				System.out.print(board[i][j]);
				
			}
//			System.out.println();
		}
	}
	
	public int[][] getBoard(){
		return this.board;
	}
	
  }
	
	
	
