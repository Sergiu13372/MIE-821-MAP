package lab2;

import java.util.ArrayList;

import lab2.Person;

public class Main {
	public static void main(String args[]) {  
		ArrayList<Person> person_list = new ArrayList<Person>();
		person_list.add(new Person("Gigel", "Florea", 1999, "April", 15, 176, "Sudor de performanta", false));
		person_list.add(new Person("Maricica", "Florea", 1998, "February", 15, 156, "Plictisita acasa", true));
		person_list.add(new Person("Nenea", "Iancu", 1899, "December", 6, 196, "Apa e doar berea slaba", false));
		person_list.add(new Person("Stefan", "cel Mare", 1433, "June", 23, 162, "47 de bastarzi", false));
		person_list.add(new Person("Gigela", "Pistol", 2004, "March", 8, 148, "Nu ii place scoala", true));
	    
		System.out.println("The person list is: ");
		
		for(Person elem: person_list) {
			System.out.println(elem);
		}
		
		System.out.println();
		
		//get the oldest person
		int oldest_current = 2021;
		Person oldest = null;
		for(Person elem: person_list) {
			if (oldest_current > elem.getYearBorn()) {
				oldest = elem;
				oldest_current = elem.getYearBorn();
			}
		}
		System.out.println("The oldest person is: " + oldest);System.out.println();
		
		//get the tallest person
		int tallest_current = 1;
		Person tallest = null;
		for(Person elem: person_list) {
			if (tallest_current < elem.getHeight()) {
				tallest = elem;
				tallest_current = elem.getHeight();
			}
		}
		
		System.out.println("The tallest person is: " + tallest);
		System.out.println();
		
		//print all the person of type women
		System.out.println("The women are: ");
		boolean counter = false;
				for(Person elem: person_list) {
					if (elem.getGender() == true) {
						System.out.println(elem);
						counter = true;
					}
				}
				if(counter == false) {

					System.out.println("There are no women here.");
				}
	}
}
