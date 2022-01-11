import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;

/**
 * Inventory class that contains the stock of the items in the storage Student
 * Student Name:Khair Ahmed Assignment 2 Student Number:040946481 Date: November
 * 3rd 2019 Course: CST8130 - Data Structures
 * 
 * @author khair
 * 
 *
 */
public class Inventory {

	private Scanner openFile;
	private Formatter createFile;
	/**
	 * arraylist that holds all inventory items
	 */

	private ArrayList<FoodItem> inventory;
	/**
	 * number of products in stock
	 */
	private int numItems;

	/**
	 * initializze arryalist
	 */
	public Inventory() {
		inventory = new ArrayList<FoodItem>();
		numItems = 0;
	}

	/**
	 * add a item to inventory
	 * 
	 * @param scanner  user input
	 * @param fromFile checks if information is being read from a file or user input
	 * @return true if item is added or false otherwise
	 *
	 * 
	 */
	public boolean addItem(Scanner scanner, boolean fromFile) {
		/**
		 * used to create specific type of food
		 */
		String itemType = "";
		/**
		 * tester food item that will be created to store information that hasnt been
		 * checked for errors
		 */
		FoodItem tester = new FoodItem();
		/*
		 * this if stament will only work if a user input is requested. it will check
		 * for errrors and ensure user enters corect input it will also ensure that
		 * everything is added in its correct posistion
		 */
		if (fromFile == false) {
			System.out.println("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)?");
			while (!(itemType.equalsIgnoreCase("v")) && !(itemType.equalsIgnoreCase("p"))
					&& !(itemType.equalsIgnoreCase("f"))) {
				itemType = scanner.next();
				switch (itemType) {
				case ("f"):
				case ("F"):
					System.out.println("Enter item code:");
					if (tester.inputCode(scanner) == false) {
						System.out.println("You have enter an invalid number");
						return false;
					}
					if (numItems == 0) {
						inventory.add(tester);
						inventory.get(numItems).addItem(scanner, false);// add fruit information
						numItems++;
						return true;
					}
					// Organize inventory by itemCode
					if (numItems > 0) {

						if (tester.compareTo(inventory.get(numItems - 1)) == 1) {
							inventory.add(tester);
							inventory.get(numItems).addItem(scanner, false);// add fruit information
							numItems++;
							return true;
						}
						for (int i = 0; i < numItems; i++) {
							if (tester.compareTo(inventory.get(i)) == -1) {
								inventory.add(i, tester);
								inventory.get(i).addItem(scanner, false);// add fruit information
								numItems++;
								return true;
							}
							if (tester.compareTo(inventory.get(i)) == 0) {
								System.out.println("The itemCode already exists");
								return false;
							}

						}

					}

					return true;
				case ("v"):
				case ("V"):
					System.out.println("Enter item code:");
					if (tester.inputCode(scanner) == false) {
						System.out.println("You have enter an invalid number");
						return false;
					}

					if (numItems == 0) {
						inventory.add(tester);
						inventory.get(numItems).addItem(scanner, false);// add fruit information
						numItems++;
						return true;
					}
					if (numItems > 0) {

						if (tester.compareTo(inventory.get(numItems - 1)) == 1) {
							inventory.add(tester);
							inventory.get(numItems).addItem(scanner, false);
							numItems++;
							return true;
						}
						for (int i = 0; i < numItems; i++) {
							if (tester.compareTo(inventory.get(i)) == -1) {
								inventory.add(i, tester);
								inventory.get(i).addItem(scanner, false);
								numItems++;
								return true;
							}
							if (tester.compareTo(inventory.get(i)) == 0) {
								System.out.println("The itemCode already exists");
								return false;
							}

						}

					}
					return true;
				case ("p"):
				case ("P"):
					System.out.println("Enter item code:");
					if (tester.inputCode(scanner) == false) {
						System.out.println("You have enter an invalid number");
						return false;
					}

					if (numItems == 0) {
						inventory.add(tester);
						inventory.get(numItems).addItem(scanner, false);// add perserve information
						numItems++;
						return true;
					}
					if (numItems > 0) {

						if (tester.compareTo(inventory.get(numItems - 1)) == 1) {
							inventory.add(tester);
							inventory.get(numItems).addItem(scanner, false);// add perserve information
							numItems++;
							return true;
						}
						for (int i = 0; i < numItems; i++) {
							if (tester.compareTo(inventory.get(i)) == -1) {
								inventory.add(i, tester);
								inventory.get(i).addItem(scanner, false);// add perserve information
								numItems++;
								return true;
							}
							if (tester.compareTo(inventory.get(i)) == 0) {
								System.out.println("The itemCode already exists");
								return false;
							}

						}

					}

					return true;
				default:// if anything other then the 3 is entered
					System.out.println("Please enter p,v, or f");
					break;

				}

			}
			/*
			 * else it will read from the file if it is true if any errors occur it will
			 * stop reading from the file
			 */
		} else {
			FoodItem tempFoodItem = new FoodItem();
			itemType = openFile.next();
			switch (itemType) {
			case "f":

				tempFoodItem = new Fruit();
				tempFoodItem.inputCode(scanner);
				if (alreadyExists(tempFoodItem) == -1) {
					inventory.add(tempFoodItem);
					if (inventory.get(numItems).addItem(openFile, true)) {
						numItems++;
						return true;
					} else {
						inventory.remove(numItems);

						return false;
					}
				} else {
					return false;
				}

			case "v":
				tempFoodItem = new Vegetable();
				tempFoodItem.inputCode(scanner);
				if (alreadyExists(tempFoodItem) == -1) {
					inventory.add(tempFoodItem);
					if (inventory.get(numItems).addItem(openFile, true)) {
						numItems++;
						return true;
					} else {
						inventory.remove(numItems);

						return false;
					}
				} else {
					return false;
				}

			case "p":
				tempFoodItem = new Preserve();
				tempFoodItem.inputCode(scanner);
				if (alreadyExists(tempFoodItem) == -1) {
					inventory.add(tempFoodItem);
					if (inventory.get(numItems).addItem(openFile, true)) {
						numItems++;
						return true;
					} else {
						inventory.remove(numItems);

						return false;
					}
				} else {
					return false;
				}

			default:
				return false;
			}

		}

		return false;

	}

	/**
	 * prints out enter stock
	 * 
	 */

	public String toString() {
		for (int i = 0; i < numItems; i++) {
			System.out.println(inventory.get(i).toString());
		}
		return " ";

	}

	/**
	 * check if item exists exist
	 * 
	 * @param item dummy item that holds user inputed itemcode needed
	 * @return i where the item exists or -1 if user doesnt find item that exist
	 */
	public int alreadyExists(FoodItem item) {
		for (int i = 0; i < numItems; i++) {
			if (inventory.get(i).isEqual(item)) {
				return i;

			}
		}

		return -1;

	}

	/**
	 * 
	 * @param scanner   user input
	 * @param buyOrSell false or true based on user information
	 *
	 * @return true if tracstion completed
	 */
	public boolean updateQuantity(Scanner scanner, boolean buyOrSell) {
		FoodItem tempFoodItem = new FoodItem();
		int arrayHolder;
		int amount = -1;
		if (buyOrSell == true) {
			System.out.print("Enter valid itemCode ");
			if (tempFoodItem.inputCode(scanner) == false) {// get code
				System.out.println("Error... could not buy item");
				return false;
			} else {

				arrayHolder = alreadyExists(tempFoodItem);
				if (arrayHolder == -1) {
					System.out.println("Code not found inventory....");
					return false;
				}

				while (amount < 0) {
					try {
						System.out.println("Enter valid quantity to buy: ");// prompt user for a quatity to buy
						amount = scanner.nextInt();
					} catch (Exception e) {
						System.out.println("Must be a positive integer.");
						scanner.next();
					}
				}
				inventory.get(arrayHolder).updateItem(amount);

			}
		}
		if (buyOrSell == false) {
			System.out.print("Enter valid itemCode ");
			if (tempFoodItem.inputCode(scanner) == false) {// get itemcode
				System.out.println("Error... could not sell item");
				return false;
			} else {
				arrayHolder = alreadyExists(tempFoodItem);
				if (arrayHolder == -1) {
					System.out.println("Code not found inventory....");
					return false;

				}

				while (amount < 0) {
					try {
						System.out.println("Enter valid quantity to sell: ");
						amount = scanner.nextInt();
					} catch (Exception e) {
						System.out.println("Must be a positive integer.");
						scanner.next();
					}
				}
				inventory.get(arrayHolder).updateItem(-1 * amount);

			}

		}

		return false;

	}

	/**
	 * searches for item in the inventory
	 * 
	 * @param scanner user input
	 */
	public void searchForItem(Scanner scanner) {
		/**
		 * tempFood item object used to find invetory object
		 */
		FoodItem tempFoodItem = new FoodItem();
		/**
		 * holds index
		 */
		int arrayHolder;
		System.out.print("Enter valid itemCode ");
		if (tempFoodItem.inputCode(scanner)) {
			arrayHolder = alreadyExists(tempFoodItem);
			if (arrayHolder != -1) {
				System.out.println(inventory.get(arrayHolder).toString());

			} else {
				System.out.println("Code not found inventory....");
			}

		} else {
			System.out.println("Error: invalid input");
		}

	}

	/**
	 * will create a file and save it to the directory
	 * 
	 * @param scanner user input
	 */
	public void saveToFile(Scanner scanner) {
		/**
		 * name of the file
		 */
		String fileName = null;

		while (true) {
			try {
				System.out.println("Name of the file to save to:");
				fileName = scanner.next();
				createFile = new Formatter(fileName);

			} catch (FileNotFoundException ex) {
				System.out.println("File Not Saved");
				scanner.next();
				break;
			}
			// copies values to file
			for (int i = 0; i < numItems; i++) {

				inventory.get(i).outputItem(createFile);

			}
			// saves file
			System.out.println(fileName + " is saved");
			createFile.close();
			break;
		}

	}

	/**
	 * takes a file from current directory and saves the information as object
	 * 
	 * @param scanner user input
	 */

	public void readFromFile(Scanner scanner) {
		/**
		 * file name that user is trying to import
		 */
		String fileName = null;
		System.out.println("Name of the file to read from: ");
		fileName = scanner.next();
		while (true) {
			try {
				openFile = new Scanner(new File(fileName));

				break;
			} catch (FileNotFoundException ex) {
				System.out.println("File Not Found, Ignoring...");
				scanner.next();
				break;
			}

		}
		int loopBreak = 0;
		// savesinformation to obecjts
		while (openFile.hasNext()) {
			if (addItem(openFile, true) == false) {
				System.out.println("Error Encountered while read the file, aborting... ");
				loopBreak++;

				break;
			}
		}
		if (loopBreak == 0) {
			System.out.println("File imported");
			openFile.close();// close file
		}

	}

}
