package com.java.cons;

public class StExnew {
			static int count;
			public void increment(){
				count++;
				System.out.println(count);
			}
			
			public static void main(String[] args){
				StExnew obj1  = new StExnew();
				StExnew obj2  = new StExnew();
				StExnew obj3  = new StExnew();
				
				obj1.increment();
				obj2.increment();
				obj3.increment();
			}
}
