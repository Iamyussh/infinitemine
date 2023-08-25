package com.java.collection;

public class Test {
public void show(int x){
	System.out.println("show front int " +x);
	
}
public void show(double x){
	System.out.println("show front double " +x);
	
}
public void show(Object x){
	System.out.println("show front Object " +x);
	
}

public static void main(String[] args){
	Test obj1 = new Test();
	obj1.show(12);
}
}
