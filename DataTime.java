/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;
import java.time.*;
import java.time.format.*;
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
		//Calculate the next tuesday of the following date
		LocalDate nextTuesday = localDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
		System.out.println("The next Tuesday = "+nextTuesday);
		//Calculate the previous tuesday of the following date
		LocalDate previousTuesday = localDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.TUESDAY));
		System.out.println("The previous Tuesday = "+previousTuesday);
		//Date on x working tuesday in the month
		int x = 3;
		LocalDate workingDay = LocalDate.now().with(TemporalAdjusters.dayOfWeekInMonth(x, DayOfWeek.TUESDAY));
		System.out.println("On x working tuesday in this month = " + workingDay);
		//Date of last working tuesday in this month
		LocalDate lastWorkingDay = LocalDate.now().with(TemporalAdjusters.lastInMonth(DayOfWeek.TUESDAY));
		System.out.println("Last working tuesday in this month = "+lastWorkingDay);
		//First day in month
		LocalDate firstDayOfMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
		System.out.println("First day of month = "+firstDayOfMonth);
		//List of all zone ids
		Set<String> zoneIds = ZoneId.getAvailableZoneIds();
		zoneIds.iterator().forEachRemaining(System.out::println);
		//Zoned data time
		ZonedDateTime zonedDateTime = ZonedDateTime.of(2024,12,12,10,30,30,0, ZoneId.of("Europe/Warsaw"));
		System.out.println("Zoned date time = "+zonedDateTime);
		//Instant to zoned date time
		Instant rightNow = Instant.now();
		ZonedDateTime zonedTime = rightNow.atZone(ZoneId.of("Europe/Warsaw"));
		System.out.println("Zoned current time = "+zonedTime);
		//Date formatter
		System.out.println("Nicely formatter date for computer = " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		System.out.println("Nicely formatter date for user = " + ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Europe/Warsaw")).format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)));
		System.out.println("Nicely formatter date for user = " + ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Europe/Warsaw")).format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));
		System.out.println("My own pattern = " + ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Europe/Warsaw")).format(DateTimeFormatter.ofPattern("EEEE, yyyy-MM-dd HH:mm:ss - zzzz")));
	}
}
