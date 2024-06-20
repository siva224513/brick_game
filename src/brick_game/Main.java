package brick_game;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Shape s = new Shape();

		System.out.println("Enter row size");
		int n = scanner.nextInt();
		System.out.println("Enter column size");
		int m = scanner.nextInt();
		char board[][] = new char[n][m];
		BrickGame brickGame = new BrickGame(n, m);
		boolean exit = false;
		while (!exit) {
			System.out.println("enter shape no");
			int shapeNo = scanner.nextInt();
			System.out.println("enter no of rotations");
			int noOfRotation = scanner.nextInt();
			System.out.println("enter starting column index");
			int columnIndex = scanner.nextInt();

			char shape[][] = s.getShape(shapeNo);
			if (shapeNo != 1) {
				shape = s.rotateShape(shape, noOfRotation, shapeNo);
			}
			brickGame.init(board, shape, n, m, shapeNo, noOfRotation, columnIndex);
			printBoard(board, n, m);

		}
		scanner.close();

	}

	private static void printBoard(char[][] board, int n, int m) {
		System.out.println("Score:" + BrickGame.score);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print("|" + board[i][j]);
			}
			System.out.println("|");
		}
		System.out.println();

	}

}
