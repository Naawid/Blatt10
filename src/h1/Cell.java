package h1;

public class Cell {
	private int indexRow;
	private int indexCol;
	private boolean alive;
	private int numLivingNeighbors;
	private boolean isAliveNextGen;

	public int getIndexRow() {
		return indexRow;
	}

	public void setIndexRow(int indexRow) {
		this.indexRow = indexRow;
	}

	public int getIndexCol() {
		return indexCol;
	}

	public void setIndexCol(int indexCol) {
		this.indexCol = indexCol;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int getNumLivingNeighbors() {
		return numLivingNeighbors;
	}

	public void setNumLivingNeighbors(int numLivingNeighbors) {
		this.numLivingNeighbors = numLivingNeighbors;
	}

	public boolean isAliveNextGen() {
		return isAliveNextGen;
	}

	public void setAliveNextGen(boolean isAliveNextGen) {
		this.isAliveNextGen = isAliveNextGen;
	}

	public Cell(int indexRow, int indexCol, boolean alive) {
		this.indexRow = indexRow;
		this.indexCol = indexRow;
		this.alive = alive;
	}

	public Cell(int indexRow, int indexCol) {
		this.indexRow = indexRow;
		this.indexCol = indexCol;

	}

	public void countLivingNeighbors(Cell[][] gridArray) {
		numLivingNeighbors = 0;
		for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {
			for (int columnOffset = -1; columnOffset <= 1; columnOffset++) {
				if (rowOffset == 0 && columnOffset == 0)
					continue;
				int r = indexRow + rowOffset;
				int c = indexCol + columnOffset;
				if (r >= 0 && r < gridArray.length &&
		                c >= 0 && c < gridArray[0].length) {
					if (gridArray[r][c].isAlive()) {
	                    numLivingNeighbors++;
	                }
				}
			}
		}
		decideNextStatus();
	}

	private void decideNextStatus() {
		if (alive) {
			isAliveNextGen = (numLivingNeighbors == 2 || numLivingNeighbors == 3);
		} else {
			isAliveNextGen = (numLivingNeighbors == 3);
		}
	}
}
