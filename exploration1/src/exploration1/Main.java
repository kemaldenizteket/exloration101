package exploration1;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

	  public static void main(String[] arg) throws InterruptedException {
	    Environment e = new Environment();
	    Agent a = new Agent();
	    Coordinate position = a.getPosition();
	    
	    int step = 0;
		int radius = a.getRange();
		int min = 0;
		
		
		final Graph g = new Graph();
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.add(g);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
		
		boolean run = true;
		
		while(run){
			min = 5000;
			step++;
//			System.out.println("Step: " + step);
			
			a.setMapCell(position, 1);
//			System.out.println("I am now: " + position.getX() + " " + position.getY());
			
			//-----Calculate the seen cells-----//
			for(int i = 0;i < Environment.width; i++ )
			{
				for(int j = 0; j < Environment.height; j++)
				{
					if((i == position.getX())&&(j == position.getY()))
					{
						continue;
					}
					Coordinate tempCo = new Coordinate();
					tempCo.setX(i);
					tempCo.setY(j);
					double distX = (position.getX() - i) * (position.getX() - i);
					double distY = (position.getY() - j) * (position.getY() - j);
					if(((distX + distY) <= (radius * radius))&&(a.getMap()[i][j]!=1)){
						if(e.getBoard()[i][j]==0)
						{
							//System.out.println("koordinatlar :" + i +" " + j);
							// Cells seen at (i,j) position, discoverable
							if(a.getCellStatus(tempCo) == 0)
								a.addMovableCells(tempCo);
							a.setMapCell(tempCo, 2);
							//System.out.println(i + " " + j);
							//System.out.println("distance " + distX + " " + distY);
						}
						else
						{
							//System.out.println("duvarlar :" + i +" " + j);
							//Cells seen at (i,j) position, undiscoverable (obstacle)
							a.setMapCell(tempCo, 3);
						}
					}
				}
			}
			//*****Calculate the seen cells*****//
			//-----Move to next seen but undiscovered cell-----//
			
			
			Coordinate nextPosition = new Coordinate();
			for(int i = 0; i < a.getMovableCells().size(); i++)
			{
//				System.out.println(a.getMovableCells().get(i).getX() +" " + a.getMovableCells().get(i).getY());
				int distance = ((position.getX() - a.getMovableCells().get(i).getX()) * (position.getX() - a.getMovableCells().get(i).getX())) 
								+ ((position.getY()-a.getMovableCells().get(i).getY())*(position.getY()- a.getMovableCells().get(i).getY()));
				if(distance < min)
				{
					min = distance;
//					System.out.println("move to : " + a.getMovableCells().get(i).getX() + " " + a.getMovableCells().get(i).getY());
//					System.out.println(min);
					nextPosition = a.getMovableCells().get(i);
				}
			}
			
			a.setPosition(nextPosition);
			position = nextPosition;
			System.out.println(nextPosition.getX() + " " + nextPosition.getY());
			a.removeMovableCells(nextPosition);
			//*****Move to next seen but undiscovered cell*****//
			run = false;
//			if(step == 4)
//				run = false;
			for(int i = 0; i < Environment.width; i++)
			{
				for(int j = 0; j < Environment.height; j ++)
				{
					if((a.getMap()[i][j] == 0)||(a.getMap()[i][j] == 2))
						run = true;
				}
			}
			
			
			g.setCoordinates(nextPosition);
			

						
			Thread.sleep(10);
			
		}
		
		int[][] testMap = new int [Environment.width][Environment.height];
		testMap = a.getMap();
		for(int i = 0; i< Environment.width; i++)
		{
			for(int j = 0; j < Environment.height; j ++){
				System.out.print(testMap[i][j]);
			}
			System.out.println();
		
		}
		int ctr = 0;
		for(int i = 0; i< Environment.width; i++)
		{
			for(int j = 0; j < Environment.height; j ++){
				if(testMap[i][j] == 2)
					ctr++;
			}
		
		}
		
		System.out.println(ctr);
	    
	    
	 }
	  
	  

}