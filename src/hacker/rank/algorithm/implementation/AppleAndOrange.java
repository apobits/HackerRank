/**
 * 
 */
package hacker.rank.algorithm.implementation;

import java.util.Scanner;

/**
 * @author Administrador
 *
 */
public class AppleAndOrange {

    public static void main(String[] args) {

	Scanner scan = new Scanner(System.in);
	int s = scan.nextInt();
	int t = scan.nextInt();
	int a = scan.nextInt();
	int b = scan.nextInt();
	int m = scan.nextInt();
	int n = scan.nextInt();

	int count = 0;
	for (int i = 0; i < m; i++) {
	    int temp = scan.nextInt();
	    if (temp > 0 && a + temp >= s && a + temp <= t) {
		count++;
	    }
	}

	System.out.println(count);
	count = 0;
	for (int i = 0; i < n; i++) {
	    int temp = scan.nextInt();
	    if (temp < 0 && b - Math.abs(temp) <= t && b - Math.abs(temp) >= s) {
		count++;
	    }
	}
	System.out.print(count);
    }

}
