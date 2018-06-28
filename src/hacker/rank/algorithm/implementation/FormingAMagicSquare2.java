package hacker.rank.algorithm.implementation;

import java.util.HashMap;

public class FormingAMagicSquare2 {

    private HashMap<Integer, Integer> getPossibleMC(int[][] magicSquare) {
	int size = magicSquare.length;
	int rowCounter = 0;
	int columnCounter = 0;
	int leftDiagonal = 0, rightDiagonal = 0;
	HashMap<Integer, Integer> numbers = new HashMap<>();
	for (int i = 0; i < size; i++) {
	    for (int j = 0; j < size; j++) {
		rowCounter += magicSquare[i][j];

		// process columns
		if (i == 0) {
		    for (int k = 0; k < size; k++) {
			columnCounter += magicSquare[i][k];
		    }

		    // sets possible magicConstants
		    setMagicConstans(numbers, columnCounter);
		    columnCounter = 0;
		}

		// process diagonals
		if (i == j) {
		    leftDiagonal += magicSquare[i][j];
		    rightDiagonal += magicSquare[i][(size - 1) - j];
		}

	    }

	    // gets possible magic numbers from rows
	    // sets possible magicConstants
	    setMagicConstans(numbers, rowCounter);
	    rowCounter = 0;
	}
	// sets possible magicConstants
	setMagicConstans(numbers, leftDiagonal);
	setMagicConstans(numbers, rightDiagonal);

	return numbers;

    }

    private void setMagicConstans(HashMap<Integer, Integer> mc, int number) {
	if (mc.containsKey(number)) {
	    mc.put(number, mc.get(number) + 1);
	} else {
	    mc.put(number, 1);
	}
    }

    public static void main(String args[]) {
	FormingAMagicSquare2 f = new FormingAMagicSquare2();
	HashMap<Integer, Integer> numbers = f.getPossibleMC(new int[][] { { 4, 9, 2 }, { 3, 5, 7 }, { 8, 1, 5 } });
	numbers.forEach((t, u) -> System.out.println("Number " + t + " " + u + " times"));
    }

}
