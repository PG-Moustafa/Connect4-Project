package Connect4;

public class GameChecker {

	public GameChecker() {
	}

	public boolean checkWin(Board board, Player player) {
		char disc = player.getDisc();
		return checkHorizontal(board, disc) || checkVertical(board, disc)
				|| checkDiagonal(board, disc);
	}

	private boolean checkHorizontal(Board board, char disc) {
		char[][] grid = board.getGrid();
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col <= grid[row].length - 4; col++) {
				if (grid[row][col] == disc && grid[row][col + 1] == disc
						&& grid[row][col + 2] == disc
						&& grid[row][col + 3] == disc) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkVertical(Board board, char disc) {
		char[][] grid = board.getGrid();
		for (int col = 0; col < grid[0].length; col++) {
			for (int row = 0; row <= grid.length - 4; row++) {
				if (grid[row][col] == disc && grid[row + 1][col] == disc
						&& grid[row + 2][col] == disc
						&& grid[row + 3][col] == disc) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkDiagonal(Board board, char disc) {
		char[][] grid = board.getGrid();
		int rows = grid.length;
		int cols = grid[0].length;

		// check downward diagonals (\ direction)
		for (int row = 0; row <= rows - 4; row++) {
			for (int col = 0; col <= cols - 4; col++) {
				if (grid[row][col] == disc && grid[row + 1][col + 1] == disc
						&& grid[row + 2][col + 2] == disc
						&& grid[row + 3][col + 3] == disc)
					return true;
			}
		}

		// check upward diagonals (/ direction)
		for (int row = 3; row < rows; row++) {
			for (int col = 0; col <= cols - 4; col++) {
				if (grid[row][col] == disc && grid[row - 1][col + 1] == disc
						&& grid[row - 2][col + 2] == disc
						&& grid[row - 3][col + 3] == disc) {
					return true;
				}
			}
		}

		return false;
	}

}
