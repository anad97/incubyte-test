package stringcalculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void returnZeroOnEmptyString() {
		assertEquals(0, StringCalculator.add(""));
	}
	
	@Test
	public void returnNumberOnOneNumber() {
		assertEquals(1, StringCalculator.add("1"));
	}
	
	@Test
	public void returnSumOnTwoNumbers() {
		assertEquals(3, StringCalculator.add("1,2"));
	}

}
