/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.text.*;
import java.time.*;
import java.util.*;
import java.util.stream.*;
import java.time.format.*;
import java.time.temporal.*;

public class Main
{
	public static void main(String[] args) {
		Locale polishLanguage = Locale.forLanguageTag("pl-PL"); //we want to use polish language
		Locale germanLanguage = Locale.GERMANY;                 //we want to use german language 
		//All available locales in our program
		Stream.of(Locale.getAvailableLocales()).forEach(System.out::println);
		Locale defaultLanguage = Locale.getDefault();
		System.out.println("Default language configuration for my system = "+defaultLanguage);
		System.out.println("The description of the locale in german language = "+defaultLanguage.getDisplayName(Locale.GERMAN));
		System.out.println("The description of the locale in polish language = "+defaultLanguage.getDisplayName(Locale.forLanguageTag("pl-PL")));
		//***********FORMATTING THE NUMBER FOR GERMANY**************************************
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(germanLanguage);
		System.out.println("The currency is formatted for Germany = "+currencyFormat.format(6.66));
		NumberFormat numberFormat = NumberFormat.getNumberInstance(germanLanguage);
		System.out.println("The number is formated for Germany = "+numberFormat.format(123456789.99));
		NumberFormat percentFormat = NumberFormat.getPercentInstance(germanLanguage);
		System.out.println("The percent is formated for Germany = "+percentFormat.format(50.20));
		//***********FORMATTING THE NUMBER FOR POLISH**************************************
		NumberFormat currencyFormatPL = NumberFormat.getCurrencyInstance(polishLanguage);
		System.out.println("The currency is formatted for Poland = "+currencyFormatPL.format(6.66));
		NumberFormat numberFormatPL = NumberFormat.getNumberInstance(polishLanguage);
		System.out.println("The number is formated for Poland = "+numberFormatPL.format(123456789.99));
		NumberFormat percentFormatPL = NumberFormat.getPercentInstance(polishLanguage);
		System.out.println("The percent is formated for Poland = "+percentFormatPL.format(50.20));
		//***********DATE AND TIME*********************************************************
		FormatStyle style = FormatStyle.FULL;
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(style).withLocale(polishLanguage);
		ZonedDateTime now = ZonedDateTime.now();
		System.out.println("Nicely formatted current date = "+formatter.format(now));
		//First day of the week in Poland
		DayOfWeek dayOfWeek = WeekFields.of(polishLanguage).getFirstDayOfWeek();
		//We also translate the name of the week using getDisplayName(TextStyle.FULL, polishLanguage)
		System.out.println("First day of week in Poland = "+dayOfWeek.getDisplayName(TextStyle.FULL, polishLanguage));
		//**********WORD SORTING***********************************************************
		Collator collator = Collator.getInstance(polishLanguage);
		List<String> places = Arrays.asList("Buenos Aires", "Córdoba", "La Plata", "Ązzzz", "Ęzzzzzz1223");
		places.sort(collator);
		places.forEach(System.out::println);
		//For german people this signs are the same. However, polish people can distingush this words
		String name1 = "Azzzz";
		String name2 = "Aźźźź";
		String name3 = "azzzz";
		collator = Collator.getInstance(germanLanguage);
		collator.setStrength(Collator.PRIMARY);
		System.out.println("PRIMARY");
		System.out.println("Comapre the special signs = "+collator.equals(name1, name2));
		System.out.println("Compare the size of signs = "+collator.equals(name1, name3));
		collator.setStrength(Collator.SECONDARY);
		System.out.println("SECONDARY");
		System.out.println("Comapre the special signs = "+collator.equals(name1, name2));
		System.out.println("Compare the size of signs = "+collator.equals(name1, name3));
		collator.setStrength(Collator.TERTIARY);
		System.out.println("TERTIARY");
		System.out.println("Comapre the special signs = "+collator.equals(name1, name2));
		System.out.println("Compare the size of signs = "+collator.equals(name1, name3));
		//Format the Text
		String msg = MessageFormat.format("Z dnia {0}, drogi {2} zwracam się z prośbą o oddanie pozyczonych pieniędzy w wysokości {1}. Pozdrawiam!", LocalDate.now(), 10.0E8, "XYZ");
		System.out.println(msg);
	}
}
