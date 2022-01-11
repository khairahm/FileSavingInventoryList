import java.util.Scanner;

/**
 * Assignment 2 contains the main menu for the inventory system Student
 * Assignment 2 Student Number:040946481 Date: November 3rd 2019 Course: CST8130
 * - Data Structures
 * 
 * 
 * @author Khair ahmed
 * 
 *
 */
public class Assign2 {
	/**
	 * methods that displays all options and calls other methods in other classes to
	 * complete menu fuctions
	 */
	public static void displayMenu() {
		/**
		 * used for user input
		 */
		Scanner input = new Scanner(System.in);
		/**
		 * stores all inventory items in the file
		 */
		Inventory inventory = null;
		/**
		 * user selection
		 */
		int selection = 0;
		/*
		 * program will quit when 5 is entered
		 */
		while (selection != 8) {
			System.out.println("Please select one of the following:");
			System.out.println("1: Add Item to Inventory");
			System.out.println("2: Display current Inventory");
			System.out.println("3: Buy Item(s)");
			System.out.println("4: Sell Item(s)");
			System.out.println("5: Search for Item");
			System.out.println("6: Save Inventory to File");
			System.out.println("7: Read Inventory from File");

			System.out.println("8: To Exit");
			System.out.print("> ");
			// ensure that only 1-5 is selected
			while (true) {
				try {
					selection = input.nextInt();
					break;
				} catch (Exception e) { // catch errors and deal with it

					System.out.println("Must be a number between 1-5");
					System.out.println("Please select one of the following:");
					System.out.println("1: Add Item to Inventory");
					System.out.println("2: Display current Inventory");
					System.out.println("3: Buy Item(s)");
					System.out.println("4: Sell Item(s)");
					System.out.println("5: Search for Item");
					System.out.println("6: Save Inventory to File");
					System.out.println("7: Read Inventory from File");
					System.out.println("8: To Exit");
					System.out.print("> ");
					input.next();
				}
			}

			switch (selection) {

			case (1):
				/*
				 * if inventory has not initalized yet then it wil here only once
				 */
				if (inventory == null) {
					inventory = new Inventory();
					inventory.addItem(input, false);// add new item to inventory list

				} else {
					inventory.addItem(input, false);

				}
				break;
			case (2):
				if (inventory == null) {// check if inventory is initialized
					System.out.println("There is currently no inventory");

				} else {
					inventory.toString();// print inventory list

				}
				break;
			case (3):
				if (inventory == null) {// check if inventory is initialized
					System.out.println("There is currently no inventory");
				} else {
					inventory.updateQuantity(input, true);// buy from inventory
				}

				break;
			case (4):
				if (inventory == null) {// check if inventory is initialized
					System.out.println("There is currently no inventory");
				} else {
					inventory.updateQuantity(input, false);// sell from inventory

				}
				break;
			case (5):
				if (inventory == null) {// check if null
					System.out.println("There is currently no inventory");

				} else {
					inventory.searchForItem(input);
				}
				break;
			case (6):
				if (inventory == null) {
					System.out.println("There is currently no inventory");

				} else {

					inventory.saveToFile(input);
				}
				break;
			case (7):
				inventory = new Inventory();
				inventory.readFromFile(input);
			case (8):
				// exit main menu
				break;
			default:
				System.out.println("Error: Input must be from 1-5");
			}

		}
		System.out.print("Exit");
		input.close();// close scanner

	}

	public static void main(String[] args) {
		/**
		 * assign1 object so we can display the main menu
		 */
		Assign2 assign2 = new Assign2();
		Assign2.displayMenu();// display main menu

	}

}
