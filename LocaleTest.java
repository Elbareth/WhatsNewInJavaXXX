/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.text.*;
import java.util.*;
import java.util.stream.*;

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
	}
}