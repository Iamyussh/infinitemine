package ccom.java.day4;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class MapDemo2 {
	public static void main(String[] args){
		Map empData  =new Hashtable();
		empData.put(1,new Employ(1,"Arnab",88842));
		empData.put(2,new Employ(2,"Santosh",90022));
		empData.put(3,new Employ(3,"Rajesh",88841));
		empData.put(4,new Employ(4,"Avhishek",88843));
		empData.put(5,new Employ(5,"Siresha",88845));
		int empno;
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter Employ no");
		empno = sc.nextInt();
		Employ employ= (Employ) empData.getOrDefault(empno,null);
		System.out.println(employ);
		
	}

}
