package postalratecalculator;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import postalratecalculator.PostalRateCalculator;

public class PostalRateTest {
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}
	
	@Test
	public void validInputs() {
		String[] args = {"H9K1J4", "H9K1S3", "10", "55", "130", "15", "regular"};
		String result = PostalRateCalculator.helper(args);
		assertEquals("$23.00", result);
	}
	
	@Test
	public void noArguments() {
		String[] args = null;
		String result = PostalRateCalculator.helper(args);
		assertEquals("Please enter required arguments.", result);
	}
	
	@Test
	public void lessThan7Args() {
		String[] args = {"H9K1J4", "H9K1S3", "10"};
		String result = PostalRateCalculator.helper(args);
		assertEquals("Not enough arguments!", result);
	}
	
	@Test
	public void moreThan7Args() {
		String[] args = {"H9K1J4", "H9K1S3", "10", "55", "130", "15", "regular", "hello", "world"};
		String result = PostalRateCalculator.helper(args);
		assertEquals("Too many arguments!", result);
	}
	
	@Test
	public void lengthTooSmall() {
		String[] args = {"H9K1J4", "H9K1S3", "0.01", "55", "130", "15", "regular"};
		String result = PostalRateCalculator.helper(args);
		assertEquals("Invalid length. Minimum = 0.1 cm, Max = 200 cm.", result);
	}
	
	@Test
	public void lengthTooBig() {
		String[] args = {"H9K1J4", "H9K1S3", "300", "55", "130", "15", "regular"};
		String result = PostalRateCalculator.helper(args);
		assertEquals("Invalid length. Minimum = 0.1 cm, Max = 200 cm.", result);
	}
	
	@Test
	public void widthTooSmall() {
		String[] args = {"H9K1J4", "H9K1S3", "10", "0.01", "130", "15", "regular"};
		String result = PostalRateCalculator.helper(args);
		assertEquals("Invalid width. Minimum = 0.1 cm, Max = 200 cm.", result);
	}
	
	@Test
	public void widthTooBig() {
		String[] args = {"H9K1J4", "H9K1S3", "10", "300", "130", "15", "regular"};
		String result = PostalRateCalculator.helper(args);
		assertEquals("Invalid width. Minimum = 0.1 cm, Max = 200 cm.", result);
	}
}
