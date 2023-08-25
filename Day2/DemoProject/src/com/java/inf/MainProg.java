package com.java.inf;

public class MainProg {
	public static void main(String[] args){
		Itrain[]  arr = new Itrain[]{new himanshu(),
				new Jitendra(),
				new Ariz()
		};
		for(Itrain itrain : arr){
			itrain.name();
			itrain.email();
		}
	}
}
