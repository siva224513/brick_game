package brick_game;

public class BrickGame {

	public static int score = 0;

	public BrickGame(int n, int m) {

	}

	public void init(char[][] board, char[][] shape, int n, int m, int shapeNo, int noOfRotation, int columnIndex) {

		placeShape(board, shape, columnIndex, n, m);

	}

	private void placeShape(char[][] board, char[][] shape, int columnIndex, int n, int m) {

		int row = shape.length;
		int col = shape[0].length;

		for (int i = 0; i < n; i++) {
			boolean isRowFiled = true;
			for (int j = 0; j < m; j++) {
				if (board[i][j] != '#') {
					isRowFiled = false;
					break;
				}
			}
			if (isRowFiled) {
				removeRow(board, i, n, m);
				score += 100;
			}
		}

		int placementRow = findPlacementRow(board, shape, columnIndex, n, m);
		if (placementRow < 0) {
			System.out.println("Collision Occurred or No space to place the shape.");
			return;
		}

		for (int i = placementRow, x = 0; i < placementRow + row && x < row; i++, x++) {
			for (int j = columnIndex, y = 0; j < columnIndex + col && y < col; j++, y++) {
				if (shape[x][y] == '#') {
					board[i][j] = shape[x][y];
				}
			}
		}

	}

	private void removeRow(char[][] board, int rowIndex, int n, int m) {
		for (int i = rowIndex; i > 0; i--) {
			for (int j = 0; j < m; j++) {
				board[i][j] = board[i - 1][j];
			}
		}

		for (int j = 0; j < m; j++) {
			board[0][j] = ' ';
		}

	}

	private int findPlacementRow(char[][] board, char[][] shape, int columnIndex, int n, int m) {
		int row = shape.length;
		int col = shape[0].length;

		int ans = Integer.MIN_VALUE;
		for (int i = 0; i <= n - row; i++) {
			boolean collision = false;
			for (int x = 0; x < row; x++) {
				for (int y = 0; y < col; y++) {
					if (i + x >= 0 & i + x < n && columnIndex + y >= 0 && columnIndex + y < m) {
						if (shape[x][y] == '#' && board[i + x][columnIndex + y] == '#') {
							collision = true;
							break;
						}
					} else {
						collision = true;
						break;
					}
				}
				if (collision) {
					break;
				}
			}
			if (!collision) {
				ans = i;
			}
		}
		return ans == Integer.MIN_VALUE ? -1 : ans;
	}

}
