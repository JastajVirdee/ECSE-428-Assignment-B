package postalratecalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PostalRateCalculator {
	
	// get input from users and pass to helper function
	public static void main(String[] args) throws IOException {
		
		// print initial message
		System.out.println("Enter From (postal code), To (postal code), Length (cm), "
				+ "Width (cm), Height (cm), Weight (kg) and "
				+ "Post Type (regular, xpress or priority).");
		System.out.print("(Separate them with spaces) : ");
		
		// get input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		// set arguments
		String[] arguments;
		if (input.equals("")) arguments = null;
		else arguments = input.split(" ");
		
		// get result
		String result = helper(arguments);
		System.out.println(result);
	}
	
	// will act as the main method, used to facilitate the
	// use of junit tests (because it has a return type)
	public static String helper(String[] arguments) {		
			
		// store output in this variable
		String result;
		
		// check if no arguments
		if (arguments == null) {
			result = "Please enter required arguments.";
		}
		
		// check if less than 7 arguments
		else if (arguments.length < 7) {
			result = "Not enough arguments!";
		}
		
		// check if more than 7 arguments
		else if (arguments.length > 7) {
			result = "Too many arguments!";
		}
		
		// convert cost to string
		else {
			int cost = getCost(arguments);
			String costString = Integer.toString(cost);
			result = "$"+costString+".00";
		}
		
		return result;
	}
	
	public static int getCost(String[] arguments) {
		
		// store cost in this variable
		int cost = 0;
				
		// add cost of postal code
		String[] postalFrom = arguments[0].split("");
		String[] postalTo = arguments[1].split("");
		int count = 0;
		while ((count < 6) && (postalFrom[count] == postalTo[count])) {
			count++;
		}
		if (count < 3) cost += 5;
		else if (count < 5) cost += 3;
		else cost += 1;
		
		// add cost of length
		double length = Double.parseDouble(arguments[2]);
		if (length < 50) cost += 2;
		else if (length < 125) cost += 4;
		else cost += 6;
		
		// add cost of width
		double width = Double.parseDouble(arguments[3]);
		if (width < 50) cost += 2;
		else if (width < 125) cost += 4;
		else cost += 6;
		
		// add cost of height
		double height = Double.parseDouble(arguments[4]);
		if (height < 50) cost += 2;
		else if (height < 125) cost += 4;
		else cost += 6;
		
		// add cost of weight
		double weight = Double.parseDouble(arguments[5]);
		if (weight < 10) cost += 3;
		else if (weight < 20) cost += 3;
		else cost += 7;
			
		// add cost of post type
		String type = arguments[6].toLowerCase();
		if (type.equals("regular")) cost += 3;
		else if (type.equals("xpress")) cost += 6;
		else cost += 15;
		
		return cost;
	}
}
