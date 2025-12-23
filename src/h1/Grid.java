package h1;

public class Grid {
	private Cell[][] gridArray;

	public Grid(Cell[] cells, int gridRows, int gridCols) {
		gridArray = new Cell[gridRows][gridCols];
		for (int i = 0; i < gridRows; i++) {
			for (int j = 0; j < gridCols; j++) {
				gridArray[i][j] = new Cell(i, j);
				for (Cell c : cells) {
					if (c.getIndexRow() == i && c.getIndexCol() == j) {
						gridArray[i][j].setAlive(true);
					}
				}
			}
		}
		for (int i = 0; i < gridRows; i++) {
			for (int j = 0; j < gridCols; j++) {
				gridArray[i][j].countLivingNeighbors(gridArray);
			}
		}
	}

	public Cell[][] getGridArray() {
		return gridArray;
	}

	public void setGridArray(Cell[][] gridArray) {
		this.gridArray = gridArray;
	}

	public void computeNextGen() {
		for (int i = 0; i < gridArray.length; i++) {
			for (int j = 0; j < gridArray[i].length; j++) {
				gridArray[i][j].countLivingNeighbors(gridArray);
			}
		}
		for (int i = 0; i < gridArray.length; i++) {
			for (int j = 0; j < gridArray[i].length; j++) {
				gridArray[i][j].setAlive(gridArray[i][j].isAliveNextGen());
			}
		}
	}

	public void computeGeneration(int n) {
		for (int a = 0; a < n; a++) {
			boolean[][] previousGen = copyGridAliveStatus();
			computeNextGen();
			if (isAllDead()) {
				break;
			}

			boolean stable = true;
			for (int i = 0; i < gridArray.length; i++) {
				for (int j = 0; j < gridArray[i].length; j++) {
					if (gridArray[i][j].isAlive() != previousGen[i][j]) {
						stable = false;
						break;
					}
				}
				if (!stable) {
					break;
				}
			}
			if (stable) {
				break;
			}
		}
	}

	private boolean[][] copyGridAliveStatus() {
		boolean[][] copy = new boolean[gridArray.length][gridArray[0].length];
		for (int i = 0; i < copy.length; i++) {
			for (int j = 0; j < copy[i].length; j++) {
				copy[i][j] = gridArray[i][j].isAlive();
			}
		}
		return copy;
	}

	private boolean isAllDead() {
		for (Cell[] row : gridArray) {
			for (Cell c : row) {
				if (c.isAlive()) {
					return false;
				}
			}
		}
		return true;
	}
}
