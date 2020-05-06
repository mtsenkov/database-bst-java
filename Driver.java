// Matthew Tsenkov
// COSC 311
// Project 3
// Version 1

import java.io.*;
import java.util.*;

public class Driver {

	public static void main(String[] args) {
		DataBase d = new DataBase();

		int response;
		Scanner keyboard = new Scanner(System.in);
		Scanner file;
		try {
			file = new Scanner(new File("names.txt"));
			while (file.hasNext()) {
				String a = file.next();
				String b = file.next();
				String c = file.next();
				d.addIt(c, b, a);
			}
		} catch (Exception e) {
			System.out.println("No File found.");
		}

		do {
			System.out.println();
			System.out.println(" 1 Add a new student");
			System.out.println(" 2 Delete a student");
			System.out.println(" 3 Find a student by ID");
			System.out.println(" 4 List students by ID increasing");
			System.out.println(" 5 List students by first name increasing");
			System.out.println(" 6 List students by last name increasing");
			System.out.println(" 7 List students by ID decreasing");
			System.out.println(" 8 List students by first name decreasing");
			System.out.println(" 9 List students by last name decreasing");
			System.out.println(" ");
			System.out.println(" 0 End");
			System.out.print(" Enter your reponse: ");

			response = keyboard.nextInt();

			switch (response) {
			case 1:
				System.out.println("ID for user to add?");
				String idToAdd = keyboard.next();
				System.out.println("First name for user to add?");
				String firstToAdd = keyboard.next();
				System.out.println("Last name for user to add?");
				String lastToAdd = keyboard.next();
				d.addIt(idToAdd, firstToAdd, lastToAdd); // Note: if the user enters an ID already in use, issue a
															// warning
				// and return to the menu
				break;
			case 2:
				System.out.println("ID for user you want to delete?");
				String id = keyboard.next();
				d.delete(id); // Note: output either "Deleted" or "ID not Found" and return to menu
				break;
			case 3:
				System.out.println("ID for user you want to find?");
				String findId = keyboard.next();
				d.find(findId); // Note: output the entire record or the message "ID not Found" and return to
								// menu
				break;
			case 4:
				d.printIdAscending();
				break;
			case 5:
				d.printFirstAscending();
				break;
			case 6:
				d.printLastAscending();
				break;
			case 7:
				d.printIdDescending();
				break;
			case 8:
				d.printFirstDescending();
				break;
			case 9:
				d.printLastDescending();
				break;
			default:
			}

		} while (response != 0);
		keyboard.close();
	}
}