package gameLogic;

public class Coordinates {
	private int row;
	private int col;
	
	public Coordinates() {
		
	}
	
	public Coordinates(int row, int col) {
		this.set_row(row);
		this.set_col(col);
	}
	
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
}
