package stringcalculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCalculatorTest {

	@Test
	public void returnZeroOnEmptyString() throws Exception {
		assertEquals(0, StringCalculator.add(""));
	}
	
	@Test
	public void returnNumberOnOneNumber() throws Exception {
		assertEquals(1, StringCalculator.add("1"));
	}
	
	@Test
	public void returnSumOnTwoNumbers() throws Exception {
		assertEquals(3, StringCalculator.add("1,2"));
	}
	
	@Test
	public void returnSumOnMultipleNumbers() throws Exception {
		assertEquals(415, StringCalculator.add("10,2,3,400"));
	}
	
	@Test
	public void returnSumWhenNewLineOperatorExists() throws Exception {
		assertEquals(6, StringCalculator.add("1\n2,3"));
	}
	
	@Test
	public void returnSumWhenDelimiterIsDifferent() throws Exception {
		assertEquals(3, StringCalculator.add("//;\n1;2"));
	}
	
	@Test
	public void returnSingleNegativeNotAllowed() {
		try {
		    StringCalculator.add("-1,3,4");
		    fail("There should be an exception");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void returnMultipleNegativeNotAllowed() {
		try {
			StringCalculator.add("-1,-3,-6,7,8,10");
			fail("There should be an exception");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void returnNumbersGreaterThanThousandNotAllowed() throws Exception{
		assertEquals(3, StringCalculator.add("2,1,2000"));
	}
	
	@Test
	public void returnAnyLengthDelimiterAllowed() throws Exception{
		assertEquals(6, StringCalculator.add("//[***]\n1***2***3"));
	}
	
	@Test
	public void returnMultipleSingleLengthDelimitersAllowed() throws Exception{
		assertEquals(6, StringCalculator.add("//[*][%]\n1*2%3"));
	}
	
	@Test
	public void returnMutipleMultiLengthDelimitersAllowed() throws Exception{
		assertEquals(10, StringCalculator.add("//[***][%%]\n1***3%%6"));
	}
	
	@Test
	public void onlyDelimiter() throws Exception{
		assertEquals(0, StringCalculator.add(","));
	}
	
	@Test
	public void chainedDelimiterTests() throws Exception{
		assertEquals(31, StringCalculator.add(",,1,2,6,7,,,10\n,5,,"));
	}
	
	@Test
	public void incorrectInputTest() throws Exception{
		assertEquals(1, StringCalculator.add("1,\n"));
	}

}
