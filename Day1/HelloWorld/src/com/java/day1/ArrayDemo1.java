package com.java.day1;

public class ArrayDemo1 {
		public void show(){
			int[] a = new int[]{1,2,3,4,652,23};
//			for(int i=0;i<a.length;i++){
//				System.out.println(a[i]);
//			}
			
			for(int i :a){
				System.out.println(i);
			}
		}
		public static void main(String[] args){
			new ArrayDemo1().show();
		}
}
