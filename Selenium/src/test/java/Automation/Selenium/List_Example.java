package Automation.Selenium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class List_Example {

	public static void main(String[] args) {
		List<String> li=new ArrayList<String>();
		List<Integer> li1=new LinkedList<Integer>();
		ArrayList<Integer> num=new ArrayList<Integer>();
		
		li.add("Names");
		li1.add(50);
		li.add("Navaneeth");
		li1.add(50);
		li1.add(50);
		
		Iterator<String> it=li.iterator();
		Iterator<Integer> it1=li1.iterator();
		
		while (it1.hasNext()) {
			Integer integer = (Integer) it1.next();
			System.out.println(integer);
		}
		
		for (Iterator iterator = li.iterator(); iterator.hasNext();) {
			String integer = (String) iterator.next();
			System.out.println(integer);
			
		}
 
	}

}
