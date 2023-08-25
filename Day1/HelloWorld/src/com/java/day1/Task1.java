package com.java.day1;

public class Task1 {
		public void showbill(double units){
			double rate;
			double bill;
			if(units<=90){
				rate = 1;
				bill = rate * 90;
				
			}
			if(units>90){
				rate  = 1;
				bill = rate * 90;
				if(units - 90>60){
					rate = 1.5;
					bill +=rate *(units-60);
				}
				else{
					rate = 1.5;
					bill+=rate*(units%90);
				}
			}
				
				
				if(units>150){
					rate  = 2;
					if(units - 150>50){
						bill +=rate *(units-50);
					}
					else{
						rate = 2;
						bill+=rate*(units%150);
					}
					if(units>200){
						rate  = 2.5;
						if(units - 200>40){
							bill +=rate *(units-40);
						}
						else{
							rate = 2.5;
							bill+=rate*(units%200);
						}
					}
						
						else if(units>240){
							rate =3;
							bill+=rate*(units-240);
						}
						
						System.out.println(bill);
					
				
					}
				
			}
			
				
			
			
			

		
		
			public static void main(String[] args){
			 double units =150;
			 
			 new Task1().showbill(units);
			}
}
