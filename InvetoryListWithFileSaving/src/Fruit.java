import java.util.Formatter;
import java.util.Scanner;

/**
 * child class that contains is used to contain information on fruit Assignment
 * 2 Student Number:040946481 Date: November 3rd 2019 Course: CST8130 - Data
 * Structures
 * 
 * @author khair
 * @see FoodItem
 *
 */
public class Fruit extends FoodItem {
	/**
	 * name of orchards
	 */
	private String orchardName;

	/**
	 * construct that does nothing
	 */
	public Fruit() {

	}

	/**
	 * prints out apple information
	 */
	@Override

	public String toString() {

		return super.toString() + " Orchard supplier: " + orchardName;
	}

	/**
	 * add item for apple * @param scanner user input
	 * 
	 * @param fromFile used to check if user is inputing or if its being read from
	 *                 file
	 * @return true if item is added
	 * @return false if not added
	 */
	@Override
	public boolean addItem(Scanner scanner, boolean fromFile) {
		if (fromFile == false) {
			super.addItem(scanner, false);
			System.out.print("Enter the name of the orchard supplier: ");
			orchardName = scanner.nextLine();
		} else {
			super.addItem(scanner, true);
			scanner.nextLine();

			orchardName = scanner.nextLine();
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
		writer.format("%s\n", orchardName);
	}

}
