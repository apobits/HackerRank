/**
 * 
 */
package hacker.rank.algorithm.implementation;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author apobits@gmail.com
 *
 */
public class LibraryFine {

    public int calculateFine(LocalDate returnedDate, LocalDate dueDate) {
	// book returned on time
	if (returnedDate.compareTo(dueDate) <= 0) {
	    return 0;
	}

	// book returned after due date but within the same month
	if (returnedDate.isAfter(dueDate) && returnedDate.getMonthValue() == dueDate.getMonthValue()
		&& returnedDate.getYear() == dueDate.getYear()) {
	    return 15 * (returnedDate.getDayOfMonth() - dueDate.getDayOfMonth());
	}

	// book returned after due date but within the same year
	if (returnedDate.isAfter(dueDate) && returnedDate.getYear() == dueDate.getYear()) {
	    return 500 * (returnedDate.getMonthValue() - dueDate.getMonthValue());
	}

	// book returned after due date but not within the same year
	if (returnedDate.isAfter(dueDate) && returnedDate.getYear() > dueDate.getYear()) {
	    return 10000;
	}
	return 0;
    }

    public static void main(String[] args) {

	try (Scanner scan = new Scanner(System.in)) {
	    int rDay = scan.nextInt();
	    int rMonth = scan.nextInt();
	    int rYear = scan.nextInt();
	    int dDay = scan.nextInt();
	    int dMonth = scan.nextInt();
	    int dYear = scan.nextInt();

	    LocalDate dueDate = LocalDate.of(dYear, dMonth, dDay);
	    LocalDate returnedDate = LocalDate.of(rYear, rMonth, rDay);
	    System.out.println(new LibraryFine().calculateFine(returnedDate, dueDate));

	}

    }

}
