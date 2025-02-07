package jdbc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateConversion {
	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter the Date in DD-MM-YYYY Format");
		String sDateString = sc.next();
		
		
		
		SimpleDateFormat sDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date = sDateFormat.parse(sDateString);
		
		
		long time = date.getTime();
		java.sql.Date sDate = new java.sql.Date(time);
		
		System.out.println(sDate);
		
//		java.sql.Date sDate = new java.sql.Date(0);
		sc.close();
	}
}
