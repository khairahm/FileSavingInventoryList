import java.util.Formatter;
import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * parent class for food item contains all generic food attribute
 * implements compareable to compare differennt objects in an arraylist
 * Assignment 2
 *   Student Number:040946481 
 *   Date: November 3rd 2019
 *   Course: CST8130 - Data Structures
 * 
 * @author khair ahmed
 *
 */
public class FoodItem implements Comparable<FoodItem> {
	/**
	 * upc code
	 */
	protected int itemCode;
	/**
	 * name of item
	 */
	protected String itemName;
	/**
	 * price of items
	 */
	protected float itemPrice;
	/**
	 * stock of items
	 */
	protected int itemQuantityInStock;
	/**
	 * cost price to purchase
	 */
	protected float itemCost;

	/**
	 * constructor that sets values to -1
	 * 
	 */
	public FoodItem() {
		itemCode = -1;
		itemName = "";
		itemPrice = -1;
		itemQuantityInStock = -1;
		itemCost = -1;
	}

	/**
	 * prints item information
	 */
	public String toString() {
		/**
		 * used to format numbers to 2 decimals
		 */
		DecimalFormat decimalFormat = new DecimalFormat("# ### ### ##0.00");

		return "Item: " + itemCode + " " + itemName + " " + itemQuantityInStock + " price: $"
				+ decimalFormat.format(itemPrice) + " cost: $" + decimalFormat.format(itemCost);
	}

	/**
	 * 
	 * @param amount that is being removed or subtracted
	 * @return true if transaction is completed
	 * @return false if transaction isnot completed
	 */
	public boolean updateItem(int amount) {

		if (amount < 0) {// check if its a negative number
			if ((amount * (-1)) < itemQuantityInStock) {// check if sell amount is greater than stock
				itemQuantityInStock += amount;
				System.out.println("Stock of " + itemName + " is : " + itemQuantityInStock);

				return true;
			} else {// print error
				System.out.println("Stock of " + itemName + " is " + itemQuantityInStock + ". " + (amount * (-1))
						+ " Cannot be subtracted from it");
				return false;
			}
		}
		// add stock if buying

		itemQuantityInStock += amount;
		System.out.println("Stock of " + itemName + " is : " + itemQuantityInStock);
		return true;

	}

	/**
	 * 
	 * @param item dummy object that holds item code
	 * @return true if item code is found
	 * @return false if item is not found
	 */
	public boolean isEqual(FoodItem item) {

		if (itemCode == item.itemCode) {
			return true;
		}

		return false;
	}

	/**
	 * add an item to inventory
	 * 
	 * @param scanner used for user input
	 * @param fromFile if it is reading from a file or if its user input
	 * @return true when input is entered properly
	 * @return false when invalid input is enter
	 * 
	 */
	public boolean addItem(Scanner scanner, boolean fromFile) {
		// prompt user to enter item code
		if (fromFile == false) {
		while (itemCode < 0) {// error check for item code
			System.out.print("Enter the code for the item: ");
			try {
				itemCode = scanner.nextInt();
			} catch (Exception e) {

				scanner.next();
			}
			if (itemCode < 0) {
				System.out.println("Invalid input: Please enter a positive value ");

			}

		}
		scanner.nextLine();
		// prompt user to enter prodct name
		System.out.print("Enter the name for the item: ");
		itemName = scanner.nextLine();

		System.out.print("Enter the quantity for the item: ");
		while (itemQuantityInStock < 0) {// error check for item quantity
			try {
				itemQuantityInStock = scanner.nextInt();
			} catch (Exception e) {
				scanner.next();
			}
			if (itemQuantityInStock < 0) {
				System.out.println("Enter a valid positive number: ");

			}

		}
		// prompt user to enter cost
		System.out.print("Enter the cost of the item: ");
		while (itemCost < 0) {// error check
			try {
				itemCost = scanner.nextFloat();
			} catch (Exception e) {
				scanner.next();
			}
			if (itemCost < 0) {
				System.out.println("Enter a valid positive number: ");

			}
		}
		// prompt user to enter sales price of item
		System.out.print("Enter the sales price of the item: ");
		while (itemPrice < 0) {
			try {
				itemPrice = scanner.nextFloat();
			} catch (Exception e) {
				scanner.next();
			}
			if (itemPrice < 0) {
				System.out.println("Enter a valid positive number: ");

			}
		}
		scanner.nextLine();
		
		return true;
		}
		if (fromFile == true){// if being read from a file
			/*
			 *take information read from a file and save it into a food item. if the object has an error in the data 
			 *member it will sand exit 
			 */
			scanner.nextLine();
			itemName = scanner.nextLine();
			try {
				itemQuantityInStock = scanner.nextInt();
			} catch (Exception e) {
				scanner.next();
				return false;
			}
			if (itemQuantityInStock < 0) {
				return false;
			}
			try {
				itemCost = scanner.nextFloat();
			} catch (Exception e) {
				scanner.next();
				return false;
			}
			if (itemCost < 0) {
				return false;
			}
			try {
				itemPrice = scanner.nextFloat();
			} catch (Exception e) {
				scanner.next();
			}
			if (itemPrice < 0) {
				return false;
			}
			
			
		}
		return true;

	}

	/**
	 * set input code for dummy user
	 * 
	 * @param scanner user inpit
	 * @return true if valid code is enter
	 * @return false if invalid code is entered
	 */
	public boolean inputCode(Scanner scanner) {
		
		try {
			itemCode = scanner.nextInt();
			if (itemCode<0) {
				return false;
			}

		} catch (Exception e) {
			scanner.next();
			return false;
		}

		return true;
	}
	/**
	 * compareTo method will compare values of the item code 
	 */
	@Override
	public int compareTo(FoodItem item) {
		if (this.itemCode<item.itemCode) {
			return -1;
		}else if (this.itemCode>item.itemCode) {
			return 1;
		}
		return 0;
	}
	/**
	 * return itemcode of object
	 * @return item code of object
	 */
	public int  getItemCode() {
		return itemCode;
	}
	/**
	 * output item saves to the file
	 * @param writer
	 */
	public void outputItem(Formatter writer) {
		writer.format("%d\n%s\n%d\n%.02f\n%.02f\n" , itemCode, itemName ,itemQuantityInStock, itemCost,itemPrice);
	}
	
	
}
