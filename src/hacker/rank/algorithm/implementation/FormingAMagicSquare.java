package hacker.rank.algorithm.implementation;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class FormingAMagicSquare {

    private static void printMatrix(int[][] matrix) {
	for (int i = 0; i < matrix.length; i++) {
	    for (int j = 0; j < matrix[i].length; j++) {
		System.out.print(matrix[i][j]);
	    }
	    System.out.println();
	}
    }

    private static void getMagicConstants(TreeSet<Integer> magicConstants, int[][] matrix) {
	// horizontal sum
	magicConstants.add(matrix[0][0] + matrix[0][1] + matrix[0][2]);
	magicConstants.add(matrix[1][0] + matrix[1][1] + matrix[1][2]);
	magicConstants.add(matrix[2][0] + matrix[2][1] + matrix[2][2]);

	// vertical sum
	magicConstants.add(matrix[0][0] + matrix[1][0] + matrix[2][0]);
	magicConstants.add(matrix[0][1] + matrix[1][1] + matrix[2][1]);
	magicConstants.add(matrix[0][2] + matrix[1][2] + matrix[2][2]);

	// diagonal sum
	magicConstants.add(matrix[0][0] + matrix[1][1] + matrix[2][2]);
	magicConstants.add(matrix[2][0] + matrix[1][1] + matrix[0][2]);

    }

    private static boolean getCost(TreeSet<Integer> costs, int[][] matrix, int magicConstant) {
	// horizontal sum
	int tempCost = 0;
	int left = 0;
	int tempMatrix[][] = new int[3][3];
	boolean flag = false;
	System.arraycopy(matrix[0], 0, tempMatrix[0], 0, 3);
	System.arraycopy(matrix[1], 0, tempMatrix[1], 0, 3);
	System.arraycopy(matrix[2], 0, tempMatrix[2], 0, 3);

	// position 0,0
	if (((tempMatrix[0][0] + tempMatrix[0][1] + tempMatrix[0][2]) != magicConstant) && ((tempMatrix[0][0] + tempMatrix[1][0] + tempMatrix[2][0]) != magicConstant)
		&& ((tempMatrix[0][0] + tempMatrix[1][1] + tempMatrix[2][2]) != magicConstant)) {
	    left = magicConstant - (tempMatrix[0][0] + tempMatrix[0][1] + tempMatrix[0][2]);
	    if ((tempMatrix[0][0] + left) < 9) {
		tempMatrix[0][0] += left;
		tempCost += Math.abs(left);
	    }
	}
	// position 0,1
	if (((tempMatrix[0][0] + tempMatrix[0][1] + tempMatrix[0][2]) != magicConstant) && ((tempMatrix[0][1] + tempMatrix[1][1] + tempMatrix[2][1]) != magicConstant)) {
	    left = magicConstant - (tempMatrix[0][1] + tempMatrix[1][1] + tempMatrix[2][1]);
	    if ((tempMatrix[0][1] + left) < 9) {
		tempMatrix[0][1] += left;
		tempCost += Math.abs(left);
	    }
	}

	// position 0,2
	if (((tempMatrix[0][0] + tempMatrix[0][1] + tempMatrix[0][2]) != magicConstant) && ((tempMatrix[0][2] + tempMatrix[1][2] + tempMatrix[2][2]) != magicConstant)
		&& ((tempMatrix[0][2] + tempMatrix[1][1] + tempMatrix[2][0]) != magicConstant)) {
	    left = magicConstant - (tempMatrix[0][2] + tempMatrix[1][1] + tempMatrix[2][0]);
	    if ((tempMatrix[0][2] + left) < 9) {
		tempMatrix[0][2] += left;
		tempCost += Math.abs(left);
	    }
	}

	// position 1,0
	if (((tempMatrix[0][0] + tempMatrix[1][0] + tempMatrix[2][0]) != magicConstant) && ((tempMatrix[1][0] + tempMatrix[1][1] + tempMatrix[1][2]) != magicConstant)) {
	    left = magicConstant - (tempMatrix[0][0] + tempMatrix[1][0] + tempMatrix[2][0]);
	    if ((tempMatrix[1][0] + left) < 9) {
		tempMatrix[1][0] += left;
		tempCost += Math.abs(left);
	    }
	}

	// position 1,1
	if (((tempMatrix[0][0] + tempMatrix[1][1] + tempMatrix[2][2]) != magicConstant) && ((tempMatrix[0][2] + tempMatrix[1][1] + tempMatrix[2][0]) != magicConstant)
		&& ((tempMatrix[0][1] + tempMatrix[1][1] + tempMatrix[2][1]) != magicConstant) && ((tempMatrix[1][0] + tempMatrix[1][1] + tempMatrix[1][2]) != magicConstant)) {
	    left = magicConstant - (tempMatrix[1][0] + tempMatrix[1][1] + tempMatrix[1][2]);
	    if ((tempMatrix[1][1] + left) < 9) {
		tempMatrix[1][1] += left;
		tempCost += Math.abs(left);
	    }
	}

	// position 1,2
	if (((tempMatrix[0][2] + tempMatrix[1][2] + tempMatrix[2][2]) != magicConstant) && ((tempMatrix[1][0] + tempMatrix[1][1] + tempMatrix[1][2]) != magicConstant)) {
	    left = magicConstant - (tempMatrix[1][0] + tempMatrix[1][1] + tempMatrix[1][2]);
	    if ((tempMatrix[1][2] + left) < 9) {
		tempMatrix[1][2] += left;
		tempCost += Math.abs(left);
	    }
	}

	// position 2,0
	if (((tempMatrix[0][0] + tempMatrix[1][0] + tempMatrix[2][0]) != magicConstant) && ((tempMatrix[0][2] + tempMatrix[1][1] + tempMatrix[2][0]) != magicConstant)
		&& ((tempMatrix[2][2] + tempMatrix[2][1] + tempMatrix[2][0]) != magicConstant)) {
	    left = magicConstant - (tempMatrix[2][2] + tempMatrix[2][1] + tempMatrix[2][0]);
	    if ((tempMatrix[2][0] + left) < 9) {
		tempMatrix[2][0] += left;
		tempCost += Math.abs(left);
	    }
	}

	// position 2,1
	if (((tempMatrix[2][0] + tempMatrix[2][1] + tempMatrix[2][2]) != magicConstant) && ((tempMatrix[2][1] + tempMatrix[1][1] + tempMatrix[0][1]) != magicConstant)) {
	    left = magicConstant - ((tempMatrix[2][1] + tempMatrix[1][1] + tempMatrix[0][1]));
	    if ((tempMatrix[2][1] + left) < 9) {
		tempMatrix[2][1] += left;
		tempCost += Math.abs(left);
	    }
	}

	// position 2,2
	if (((tempMatrix[2][0] + tempMatrix[2][1] + tempMatrix[2][2]) != magicConstant) && ((tempMatrix[0][2] + tempMatrix[1][2] + tempMatrix[2][2]) != magicConstant)
		&& ((tempMatrix[0][0] + tempMatrix[1][1] + tempMatrix[2][2]) != magicConstant)) {
	    left = magicConstant - ((tempMatrix[0][0] + tempMatrix[1][1] + tempMatrix[2][2]));
	    if ((tempMatrix[2][2] + left) < 9) {
		tempMatrix[2][2] += left;
		tempCost += Math.abs(left);
	    }
	}

	costs.add(tempCost);
	System.out.println("MagicConstant " + magicConstant);
	printMatrix(tempMatrix);
	System.out.println();
	if ((tempMatrix[0][0] + tempMatrix[0][1] + tempMatrix[0][2]) != magicConstant || (tempMatrix[0][0] + tempMatrix[1][1] + tempMatrix[2][2]) != magicConstant
		|| (tempMatrix[0][0] + tempMatrix[1][0] + tempMatrix[2][0]) != magicConstant || (tempMatrix[0][1] + tempMatrix[1][1] + tempMatrix[2][1]) != magicConstant
		|| (tempMatrix[0][2] + tempMatrix[1][2] + tempMatrix[2][2]) != magicConstant || (tempMatrix[0][2] + tempMatrix[1][1] + tempMatrix[2][0]) != magicConstant
		|| (tempMatrix[1][0] + tempMatrix[1][1] + tempMatrix[1][2]) != magicConstant || (tempMatrix[2][0] + tempMatrix[2][1] + tempMatrix[2][2]) != magicConstant) {
	    flag = true;
	}

	return flag;
    }

    public static void main(String[] args) {

	try (Scanner scan = new Scanner(System.in)) {
	    int[][] matrix = new int[3][3];
	    TreeSet<Integer> magicConstants = new TreeSet<>();
	    TreeSet<Integer> costs = new TreeSet<>();

	    for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
		    matrix[i][j] = scan.nextInt();
		}
	    }

	    getMagicConstants(magicConstants, matrix);

	    Iterator<Integer> it = magicConstants.iterator();
	    while (it.hasNext()) {
		boolean flag = false;
		int mc = it.next();
		do {
		    flag = getCost(costs, matrix, mc);
		} while (flag);
	    }

	    System.out.println(costs.pollFirst());
	}

    }

}
