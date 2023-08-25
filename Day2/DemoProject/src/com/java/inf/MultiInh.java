package com.java.inf;

public class MultiInh implements Ione,Itwo {

	@Override
	public void email() {
		// TODO Auto-generated method stub
		System.out.println("Email is infinite@gmail.com");
	}

	@Override
	public void name() {
		// TODO Auto-generated method stub
		System.out.println("Name is Infinite");
	}
	
	public static void main(String[] args){
		MultiInh obj = new MultiInh();
		obj.name();
		obj.email();
	}

}
