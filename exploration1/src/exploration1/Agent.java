package exploration1;

import java.util.ArrayList;
import java.util.List;

public class Agent {
	public static int deployTime = 3;
	public enum cellStatus {UNDISCOVERED, DISCOVERED, SEEN, OBSTACLE};
	private int range;
	private Coordinate position = new Coordinate();
	private int[][] map = new int[Environment.width][Environment.height];
	private List<Coordinate> movableCells = new ArrayList<>();
	
	public Agent(){
		this.range = 2;
		this.position.setX(1);
		this.position.setY(1);
		
	}
	
	public int getRange(){
		return this.range;
	}
	
	public Coordinate getPosition(){
		return this.position;
	}
	
	public void setPosition(Coordinate c){
		this.position = c;
	}
	
	public int[][] getMap(){
		return this.map;
	}
	
	public void setMapCell(Coordinate c, int status ){
		this.map[c.getX()][c.getY()] = status;
	}
	
	public List<Coordinate> getMovableCells(){
		return this.movableCells;
	}
	
	public void addMovableCells(Coordinate c){
		if (this.movableCells.contains(c) == false)
			this.movableCells.add(c);
	}
	public int getCellStatus(Coordinate c){
		return map[c.getX()][c.getY()];
	}
	
	public void removeMovableCells(Coordinate c){
		if(this.movableCells.contains(c) == true)
			this.movableCells.remove(c);
	}
	
	
}
