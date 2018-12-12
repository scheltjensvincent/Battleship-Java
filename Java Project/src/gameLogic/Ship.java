package gameLogic;

//import java.util.ArrayList;

public class Ship {
	private Coordinates startco;
	private Coordinates endco;
	//private ArrayList<Coordinates> coordinates = new ArrayList<Coordinates>();

	private String name;
	
	public Ship(String name, int startco_row, int startco_col, int endco_row, int endco_col) {	
		this.setStartco(startco_row, startco_col);
		this.setEndco(endco_row, endco_col);
		this.setName(name);
		
		/*
		 for (int i = startco_row; i < endco_row; i++ ) {
			for (int j = startco_col; i < endco_col; j++) {
				this.setCoordinates(i, j);
			}
		}
		 */
}	
	
	
	
	public void setStartco(int row, int col) {
		this.startco.set_row(row);
		this.startco.set_col(col);
	}
	
	public void setEndco(int row, int col) {
		this.endco.set_row(row);
		this.endco.set_col(col);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Coordinates getStartco() {
		return this.startco;
	}
	
	public Coordinates getEndco() {
		return this.endco;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	/*
	public void setCoordinates(int row, int col) {
		this.coordinates.add(new Coordinates(row, col));
	}
	
	public ArrayList<Coordinates> getCoordinates() {
		return this.coordinates;
	}
	*/
	
}
