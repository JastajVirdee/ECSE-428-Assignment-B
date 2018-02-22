package postalratecalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PostalRateCalculator {
	
	// get input from users and pass to helper function
	public static void main(String[] args) throws IOException {
		System.out.println("Enter From (postal code), To (postal code), Length (cm), "
				+ "Width (cm), Height (cm), Weight (kg) and "
				+ "Post Type (regular, xpress or priority).");
		System.out.print("(Separate them with spaces) : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] arguments = input.split(" ");
		helper(arguments);
	}
	
	// will act as the main method, used to facilitate the
	// use of junit tests (because it has a return type)
	public static String helper(String[] arguments) {
		return "";
	}
}
