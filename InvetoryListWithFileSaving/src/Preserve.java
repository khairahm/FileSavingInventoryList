import java.util.Formatter;
import java.util.Scanner;
/**
 * child class that contains is used to contain information on preserve
 * Assignment 2
 *   Student Number:040946481 
 *   Date: November 3rd 2019
 *   Course: CST8130 - Data Structures
 * 
 * @author khair
 * @see FoodItem
 *
 */

public class Preserve extends FoodItem{
	/** jar size in ml
	 * 
	 */
	private int jarSize;
	/** constructor that sets jarSize to -1
	 * 
	 */
	public Preserve() {
		jarSize=-1;
	}
	/**
	 * prints out perserve information
	 */
	@Override
	public String toString() {
		
		return super.toString() + " Size: "+ jarSize+ "mL";
	}
	
	/**
	 * add item for perserve 
	 *  * @param scanner user input
	 * @param fromFile used to check if user is inputing or if its being read from file
	 * @return true if item is added
	 * @return false if not added
	 */
	public boolean addItem(Scanner scanner, boolean fromFile) {
		if (fromFile == false	) {
		super.addItem(scanner, false);
		
		while (true) {
		try {
			System.out.print("Enter the size of the jar in millimeters: ");
		jarSize = scanner.nextInt();
		if (jarSize<0) {
			System.out.println("Must be positive int");
			continue;
		}else {
			break;
		}
		}catch(Exception e) {
			System.out.println("Must be positive int");

			scanner.next();
		}
		}
		}else {
			super.addItem(scanner, true);
			
			try {
				jarSize = scanner.nextInt();
				} catch (Exception e) {
				scanner.next();
				return false;
			}
			if (jarSize < 0) {
				return false;

			}
		}
		return true;
	}
	/**
	 * output item saves to the file
	 * @param writer is the object that will write to the file
	 */

	@Override 
	
	public void outputItem(Formatter writer) {
		writer.format("p\n");
		super.outputItem(writer);
		writer.format("%d\n", jarSize);
	}
	

}
