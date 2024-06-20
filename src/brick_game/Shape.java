package brick_game;

public class Shape {
	private char[][][] coordinates;

	public Shape() {
		this.coordinates = new char[5][2][2];

		coordinates[0] = new char[][] { { '#', '#' }, { '#', '#' } };
		coordinates[1] = new char[][] { { '#' }, { '#' }, { '#' }, { '#' } };
		coordinates[2] = new char[][] { { '#', ' ' }, { '#', ' ' }, { '#', '#' } };
		coordinates[3] = new char[][] { { '#', '#', ' ' }, { ' ', '#', '#' } };
		coordinates[4] = new char[][] { { ' ', '#', ' ' }, { '#', '#', '#' } };

	}

	public char[][] getShape(int shapeNo) {
		return coordinates[shapeNo - 1];
	}

	public char[][] rotateShape(char[][] shape, int noOfRotation, int shapeNo) {
		noOfRotation = (noOfRotation % 4);
		char temp[][] = shape;

		if (shapeNo == 2) {
			if (noOfRotation % 2 == 0)
				return temp;
			else {
				return new char[][] { { '#', '#', '#', '#' } };
			}
		}

		while (noOfRotation-- > 0) {
			char rotatedShape[][] = null;
			rotatedShape = transposeMatrix(temp);
			rotatedShape = reverseRows(rotatedShape);
			temp = rotatedShape;

		}

		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				System.out.print(temp[i][j]);
			}
			System.out.println();
		}
		System.out.println();

		return temp;
	}

	private char[][] reverseRows(char[][] rotatedShape) {

		for (int i = 0; i < rotatedShape.length; i++) {
			int mid = rotatedShape[i].length / 2;
			for (int j = 0; j < mid; j++) {
				char temp = rotatedShape[i][j];
				rotatedShape[i][j] = rotatedShape[i][rotatedShape[i].length - 1 - j];
				rotatedShape[i][rotatedShape[i].length - 1 - j] = temp;
			}
		}

		return rotatedShape;
	}

	private char[][] transposeMatrix(char[][] shape) {
		int n = shape.length;
		int m = shape[0].length;
		char temp[][] = new char[m][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp[j][i] = shape[i][j];
			}
		}

		return temp;
	}

}
