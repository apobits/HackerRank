/**
 * 
 */
package hacker.rank.algorithm.implementation;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author apobits@gmail.com
 *
 */
public class ExtraLongFactorials {

    public static BigInteger getFactorial(int number) {
	if (number == 1) {
	    return new BigInteger(String.valueOf(number));
	}
	return getFactorial(number - 1).multiply(new BigInteger(String.valueOf(number)));
    }

    public static void main(String[] args) {
	try (Scanner scan = new Scanner(System.in)) {
	    int number = scan.nextInt();
	    System.out.println(getFactorial(number));
	}

    }

}
