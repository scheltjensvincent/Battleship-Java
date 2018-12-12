package gameLogic;

public class Coordinates {
	private int row;
	private int col;
	
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
}
