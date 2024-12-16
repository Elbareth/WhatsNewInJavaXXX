/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.time.*;
import java.time.temporal.*;

public class Main
{
	public static void main(String[] args) {
		Instant start = Instant.now(); //current data as a date
		System.out.println("Current date "+start);
		Instant end = Instant.now();
		Duration duration = Duration.between(start, end); // the difference between two dates
		System.out.println("Duration = "+duration.toMillis());
		Instant nextYear = Instant.now().plusSeconds(31536000); //adding next year
		System.out.println("Next year = "+nextYear);
		/*---------------------LOCALDATE----------------------------------*/
		LocalDate localDate = LocalDate.now();
		System.out.println("Current date = "+localDate);
		LocalDate anotherTime = LocalDate.of(1966,2,22);
		System.out.println("Another date = "+anotherTime);
		LocalDate afterOneYear = LocalDate.now().plusYears(1);
		System.out.println("In another year = "+afterOneYear);
		long amountOfDays = localDate.until(afterOneYear, ChronoUnit.DAYS);
		System.out.println("Amount of days between two dates = "+amountOfDays);
		//The day of the week for example monday = 1
		int dayOfWeek = LocalDate.of(1970,1,1).getDayOfWeek().getValue();
		System.out.println("Day of week = "+dayOfWeek);
		boolean isAfter = localDate.isAfter(anotherTime);
		boolean isBefore = localDate.isBefore(anotherTime);
		System.out.println("Is now = "+localDate+" before another day = "+anotherTime+" ? = "+isBefore+" or after = "+isAfter);
		//is leap year - rok przestępny
		System.out.println("Leap year = "+localDate.isLeapYear());
	}
}
