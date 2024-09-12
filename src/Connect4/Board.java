package Connect4;

public class Board {

	private final int ROWS = 6;
	private final int COLS = 7;
	private char[][] grid;

	public Board() {
		grid = new char[ROWS][COLS];
		// Initialize board with empty spaces
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				grid[row][col] = ' ';
			}
		}
	}

	public boolean dropDisc(int col, char disc) {
		for (int row = ROWS - 1; row >= 0; row--) {
			if (grid[row][col] == ' ') {
				grid[row][col] = disc;
				return true;
			}
		}
		System.out.println("Column is full. Choose a different column.");
		return false;
	}

	public void display() {
		// Display the Broad
		System.out.println();
		char cols[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
		System.out.println("A   B   C   D   E   F   G");
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] != ' ')
					System.out.print("**  ");
				else
					System.out.print(cols[j] + "" + (i + 1) + "  ");
			}
			System.out.println();
		}
	}

	public boolean isFull() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == ' ')
					return false;
			}
		}
		return true;
	}

	public boolean hasWinner(Board board, Player currentPlayer) {
		GameChecker checker = new GameChecker();
		if (checker.checkWin(board, currentPlayer)) {
			return true;
		}
		return false;
	}

	public char[][] getGrid() {
		return grid;
	}

	public void setGrid(char[][] grid) {
		this.grid = grid;
	}

	public int getROWS() {
		return ROWS;
	}

	public int getCOLS() {
		return COLS;
	}

}
