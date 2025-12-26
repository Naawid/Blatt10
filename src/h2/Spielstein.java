package h2;

public class Spielstein {
	private int currentRow;
	private int currentCol;
	private Spielbrett brett;

	public int getCurrentRow() {
		return currentRow;
	}

	public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}

	public int getCurrentCol() {
		return currentCol;
	}

	public void setCurrentCol(int currentCol) {
		this.currentCol = currentCol;
	}

	public Spielbrett getBrett() {
		return brett;
	}

	public void setBrett(Spielbrett brett) {
		this.brett = brett;
	}

	public Spielstein(Spielbrett brett, int indexRow, int indexCol) {
		setCurrentRow(indexRow);
		setCurrentCol(indexCol);
		setBrett(brett);
	}

	private boolean movesOut() {
		char direc = getBrett().getFeld(currentRow, currentCol).getDirection();
		if (currentRow == 0 && direc == 'U') return true;
		if (currentRow == brett.getDim() - 1 && direc == 'D')return true;
		if (currentCol == 0 && direc == 'L') return true;
		if (currentCol == brett.getDim() - 1 && direc == 'R') return true;
		return false;
	}

	public void go(int n) {
		if (n == 0 || getBrett().getFeld(currentRow, currentCol).isBoese())
			return;
		for (int i = 1; i <= n; i++) {
			char direc = getBrett().getFeld(currentRow, currentCol).getDirection();
			if (movesOut()) {
				return;
			}
			if (direc == 'R') {
				setCurrentCol(currentCol + 1);
			}
			if (direc == 'L') {
				setCurrentCol(currentCol - 1);
			}
			if (direc == 'U') {
				setCurrentRow(currentRow - 1);
			}
			if (direc == 'D') {
				setCurrentRow(currentRow + 1);
			}
		}
	}
}
