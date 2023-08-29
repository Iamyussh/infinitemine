package com.java.day5;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateDiff {
	public void show(String startDate,String enddate) throws ParseException{
		SimpleDateFormat  sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date stDate = sdf.parse(startDate);
		Date eDate = sdf.parse(enddate);
		long diff = eDate.getTime() - stDate.getTime();
		long days = (diff/(1000*60*60*24));
		days++;
		System.out.println("Total leave Applied days " +days);
		
	}
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter leave Start Date (dd-MM-yyyy)");
			String startDate = sc.next();
			
			System.out.println("Enter leave End Date (dd-MM-yyyy)");
			String enddate = sc.next();
			
			DateDiff obj = new DateDiff();
			try{
				obj.show(startDate,enddate);
				
			}
			catch(ParseException e){
				e.printStackTrace();
			}
		}
}
