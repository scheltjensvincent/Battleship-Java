package gameLogic;

//import java.util.ArrayList;

public class Ship {
	private Coordinates startco;
	private Coordinates endco;
	//private ArrayList<Coordinates> coordinates = new ArrayList<Coordinates>();

	private String name;
	
	public Ship() {
		
	}
	
	public Ship(Coordinates startCo, Coordinates endCo) {
		this.setStartco(startCo);
		this.setEndco(endCo);
	}
	
	public Ship(String name, Coordinates startCo, Coordinates endCo) {	
		this.setStartco(startCo);
		this.setEndco(endCo);
		this.setName(name);
		
		/*
		 for (int i = startco_row; i < endco_row; i++ ) {
			for (int j = startco_col; i < endco_col; j++) {
				this.setCoordinates(i, j);
			}
		}
		 */
	}	
	
	
	
	public void setStartco(Coordinates startCo) {
		this.startco = startCo;
	}
	
	public void setEndco(Coordinates endCo) {
		this.endco = endCo;
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
