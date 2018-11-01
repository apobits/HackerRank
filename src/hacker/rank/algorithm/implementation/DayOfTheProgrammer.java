/**
 * 
 */
package hacker.rank.algorithm.implementation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @author Administrador
 *
 */
public class DayOfTheProgrammer {

    public static void main(String[] args) {
	try (Scanner scan = new Scanner(System.in)) {
	    int year = scan.nextInt();
	    int dayOfYear = year < 1918 && year % 4 == 0 && year % 400 != 0 && year % 100 == 0 ? 255 : 256;
	    if (year == 1918) {
		dayOfYear += 13;
	    }
	    Calendar calendar = new GregorianCalendar();
	    calendar.set(Calendar.YEAR, year);
	    calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);

	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH:MM:SS");
	    System.out.println(sdf.format(calendar.getTime()));

	}
    }

}
