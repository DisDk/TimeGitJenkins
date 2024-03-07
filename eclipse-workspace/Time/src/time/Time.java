package time;

import java.util.Scanner;

/**
 * @modfied by Liz Dancy
 * Used to show how to catch multiple Exceptions and then as a base class
 * for the testing exercise with JUnit
 *
 */


import javax.swing.JOptionPane;

/**
 * Taken from Wendi Jollymore :http://www-acad.sheridanc.on.ca/~jollymor/prog24178/oop2.html
 * @modfied by Liz Dancy
 * Used  as a base class
 * for the testing exercise with JUnit
 *  Winter 2021
 */
public class Time
{
	public static void main(String[] args) 
	{
		System.out.println("Github");
		try
		{
			
		String time = JOptionPane.showInputDialog(null,
			"Enter a time in the format hh:mm:ss:mmmm", "Enter Time",
			JOptionPane.QUESTION_MESSAGE);
		
		double totalSeconds = getTotalSeconds(time);
		JOptionPane.showMessageDialog(null, totalSeconds, "Total Seconds",
			JOptionPane.INFORMATION_MESSAGE);
		}
		catch(StringIndexOutOfBoundsException e)
		{
			JOptionPane.showMessageDialog(null,
					"You entered the time in the wrong format.\n" +
					"Please enter the time in the form hh:mm:ss:mmmm",
					"Invalid Time", JOptionPane.ERROR_MESSAGE);
		}
		
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null,
					"You entered an invalid time.\nPlease enter numbers only.",
					"Invalid Time",	JOptionPane.ERROR_MESSAGE);
		}
		catch(Exception e)
		{
			System.out.println("An unexpected Exception occurred");
		}
	}

	public static double getTotalSeconds(String time)throws NumberFormatException, StringIndexOutOfBoundsException {
		
		double hours = getTotalHours(time);
		//we will eventually multiply the hours by 3600 + the minutes by 60 + the seconds
		double minutes = getTotalMinutes (time);
		double seconds = getSeconds(time);
		double milliSeconds = getMilliSeconds(time);
		milliSeconds /= 1000;
		return hours * 3600 + minutes * 60 + seconds + milliSeconds % 60;	

	}
	
	public static double getSeconds(String time) throws NumberFormatException, StringIndexOutOfBoundsException 
	{		
	    return Integer.parseInt(time.substring(6, 8));
	}
	

	public static double getTotalMinutes(String time) throws NumberFormatException, StringIndexOutOfBoundsException
	{
		if (time.length() < 13) {
	        throw new NumberFormatException("Invalid time format. Please enter 	the time in the form hh:mm:ss:mmmm");
	    }
	    return Integer.parseInt(time.substring(3, 5));
	}

	public static double getTotalHours(String time)throws NumberFormatException, StringIndexOutOfBoundsException
	{
		return Integer.parseInt(time.substring(0,2));
	}
	
	public static double getMilliSeconds(String time) throws NumberFormatException, StringIndexOutOfBoundsException 
	{
		return Integer.parseInt(time.substring(9, 13));
	}
	
	
	
}



