package h2;

public class Spielbrett {
	private int dim;
	private Feld[][] brett;

	public int getDim() {
		return dim;
	}

	public void setDim(int dim) {
		this.dim = dim;
	}

	public Feld[][] getBrett() {
		return brett;
	}

	public void setBrett(Feld[][] brett) {
		this.brett = brett;
	}
	
	public Spielbrett(int dim) {
		setDim(dim);
		Feld[][] a = new Feld[dim][dim];
		setBrett(a);
	}
	public Feld getFeld(int zeile, int spalte) {
	    return brett[zeile][spalte];
	}
}
