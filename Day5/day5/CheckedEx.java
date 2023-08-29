package com.java.day5;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class CheckedEx {
	// checked exception osccurs at coding part
	public void show(String dt) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = sdf.parse(dt);
		System.out.println(date);
	}
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Date (dd-MM-yyyy ) Format" );
			String date  = sc.next();
			CheckedEx obj = new CheckedEx();
			
			try {
				obj.show(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// only try catch block are allowed in the main  method
		}
}
