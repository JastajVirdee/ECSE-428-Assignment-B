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
		
		else {
			
			// check dimensions
			boolean length = checkDimension(arguments[2]);
			boolean width = checkDimension(arguments[3]);
			boolean height = checkDimension(arguments[4]);
			boolean weight = checkWeight(arguments[5]);
			if (!length) result = "Invalid length. Minimum = 0.1 cm, Max = 200 cm.";
			else if (!width) result = "Invalid width. Minimum = 0.1 cm, Max = 200 cm.";
			else if (!height) result = "Invalid height. Minimum = 0.1 cm, Max = 200 cm.";
			else if (!weight) result = "Invalid weight. Minimum = 0 cm, Max = 30 cm.";
			
			else {
				
				// check postal shipping type 
				boolean postalType = checkPostType(arguments[6]);
				if (!postalType) result = "Invalid Post Type. Choices are: Regular, Xpress or Priority.";
				
				else {
					
					// check if from postal code has 6 characters
					boolean postalFromLength = checkPostLength(arguments[0]);
					if (!postalFromLength) result = "Invalid From Postal Code. The postal code must have a length of 6.";
					
					else {
						
						// check if from postal code has valid characters
						boolean postalFromCharacters = checkPostalCharacters(arguments[0]);
						if (!postalFromCharacters) result = "Invalid From Postal Code. The postal code must be only composed of letters and digits with no spaces.";
						
						else {
							
							// check if to postal code has 6 characters
							boolean postalToLength = checkPostLength(arguments[1]);
							if (!postalToLength) result = "Invalid Destination Postal Code. The postal code must have a length of 6.";
							
							else{
								
								// check if to postal code has valid characters
								boolean postalToCharacters = checkPostalCharacters(arguments[1]);
								if (!postalToCharacters) result = "Invalid Destination Postal Code. The postal code must be only composed of letters and digits with no spaces.";
								
								else {
									
									int cost = getCost(arguments);
									String costString = Integer.toString(cost);
									result = "$"+costString+".00";
								}
							}
						}
					}
				}
			}
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
	
	// check if dimension is valid
	public static boolean checkDimension(String dim) {
		double dimension = Double.parseDouble(dim);
		if (dimension < 0.1 || dimension > 200) return false;
		else return true;
	}
	
	// check if weight is valid
	public static boolean checkWeight(String wei) {
		double weight = Double.parseDouble(wei);
		if (weight < 0 || weight > 30) return false;
		else return true;
	}
	
	// check if post type is valid 
	public static boolean checkPostType(String postType) {
		String postTypeLowerCase = postType.toLowerCase();
		if (postTypeLowerCase.equals("regular")) return true;
		else if (postTypeLowerCase.equals("xpress")) return true;
		else if (postTypeLowerCase.equals("priority")) return true;
		else return false;
	}
	
	// check if postal code has 6 characters
	public static boolean checkPostLength(String post) {
		int postLength = post.length();
		if (postLength == 6) return true;
		else return false;
	}
	
	// check if postal code contains only digits and letters
	public static boolean checkPostalCharacters(String post) {
		char[] charsFromString = post.toCharArray();
		for (char current : charsFromString) {
			if((!Character.isLetter(current))  && (!Character.isDigit(current))) {
	            return false;
	        }
		}
		return true;		
	}
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

