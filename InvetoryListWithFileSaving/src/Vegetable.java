import java.util.Formatter;
import java.util.Scanner;

/**
 * child class that contains is used to contain information on vegetables
 * Assignment 2 Student Number:040946481 Date: November 3rd 2019 Course: CST8130
 * - Data Structures
 * 
 * 
 * @author khair
 * @see FoodItem
 *
 */
public class Vegetable extends FoodItem {
	/**
	 * name of the farm
	 */
	private String farmName;

	/**
	 * constructor that does nothing
	 * 
	 */
	public Vegetable() {

	}

	/**
	 * prints all information on product
	 * 
	 */
	@Override
	public String toString() {

		return super.toString() + " Farm supplier: " + farmName;
	}

	/**
	 * adds all vegetable information
	 * 
	 * @param scanner  user input
	 * @param fromFile used to check if user is inputing or if its being read from
	 *                 file
	 * @return true if item is added
	 * @return false if not added
	 */
	public boolean addItem(Scanner scanner, boolean fromFile) {
		if (fromFile == false) {
			super.addItem(scanner, false);
			System.out.print("Enter the name of the farm supplier: ");
			farmName = scanner.nextLine();
		} else {
			super.addItem(scanner, true);
			scanner.nextLine();

			farmName = scanner.nextLine();
		}
		return true;
	}

	/**
	 * output item saves to the file
	 * 
	 * @param writer is the object that will write to the file
	 */

	@Override
	public void outputItem(Formatter writer) {
		writer.format("f\n");
		super.outputItem(writer);
		writer.format("%s\n", farmName);

	}

}
