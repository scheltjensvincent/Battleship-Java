package gameLogic;

/*
 * defines coordinates and correctly parses an integer into coordinates
 */

public class Coordinates {
	
	//declaration of the variables used
	private int row;
	private int col;
	
	public Coordinates() {
		
	}
	
	//coordinate made up out of a row and col
	public Coordinates(int row, int col) {
		this.set_row(row);
		this.set_col(col);
	}
	
	
	//correctly parses an integer into coordinates with special care for values < 10 
	public static Coordinates parseIntoCoordinates(int cell) {
		String strCell = Integer.toString(cell);
		int i;
		int j;
		
		if (cell < 10) {
			i = 0;
			j = Integer.parseInt(strCell);
		}
		else {
			i = Integer.parseInt(Integer.toString(cell).substring(0, 1)); //gets the first digit
			j = Integer.parseInt(strCell.substring(strCell.length() - 1));
		}
		
		Coordinates coordinate = new Coordinates(i, j);
		
		return coordinate;
	}
	
	//getters and setters for this class
	public void set_row(int row) {	
		this.row = row;
	}
	
	public void set_col(int col) {
		this.col = col;
	}
	
	public int get_row(){
		return this.row;
	}
	
	public int get_col(){
		return this.col;
	}
}
