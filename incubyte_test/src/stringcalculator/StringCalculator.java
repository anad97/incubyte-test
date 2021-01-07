package stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	
	public static int add(String str) throws Exception {
		//return simpleStringAdd(str);
		return regexStringAdd(str);
	}
	
	//Regex function to handle chained delimiters
	public static int regexStringAdd(String arg) throws Exception {
		int sum = 0;
		List<String> allMatches = new ArrayList<String>();
		String negatives = "";
		Pattern pattern = Pattern.compile("[-]{0,1}[\\d]+");
		Matcher matcher = pattern.matcher(arg);
		 while (matcher.find()) {
		   allMatches.add(matcher.group());
		 }
		 for(int i = 0; i < allMatches.size(); i++) {
			 int currNumber = Integer.parseInt(allMatches.get(i));
			 System.out.print(allMatches.get(i) + " ");
			 if (currNumber <= 1000 && currNumber > 0) {
				 sum += currNumber;
			 } 
			 if (currNumber < 0) { 
				 negatives += allMatches.get(i) + " ";
			 }
			  
		 }
		 if (!negatives.isEmpty()) {
			 throw new NumberFormatException("Negatives not allowed: " + negatives);
		 }
		 System.out.println("");
		return sum;
	}
	
	//The earlier code extracted as a function
	public static int simpleStringAdd(String str) throws Exception{
		if(str.length() == 0) {
		return 0;
	}
	else if (str.length() == 1) {
		return Integer.parseInt(str);
	}
	else {
		String delimiter = ",";
		//If condition to identify a new delimiter
		if(str.contains("//")) {
			//Check for delimiter with more than one character
			if(str.contains("[")) {
				int endIndex = str.indexOf("]");
				str = str.substring(endIndex+1).replaceAll("[^0-9]+", ",");
				} else {
			int delimiterIndex = str.indexOf("//") + 2;
			delimiter = Character.toString(str.charAt(delimiterIndex));
			str = str.replaceAll("//" + delimiter, "");
				}
		}
		if(str.contains("\n")) {
			str = str.replaceAll("\n", delimiter); //removes new line operator
		}
		//This if condition removes any delimiter in the start of the string (if any)
		if(str.startsWith(delimiter)) {
			str = str.replaceFirst(delimiter, "");
		}
		str = str.trim();
		System.out.println("String: " + str);
		String[] nums = str.split(delimiter);
		return sumFunction(nums);
	}
	}
	
	public static int sumFunction(String ...nums) throws Exception {
		int sum = 0;
		String negatives = "";
		for(int i = 0; i < nums.length; i++) {
			if (nums[i] == null) {
				continue;
			}
			System.out.println("Numbers: " + nums[i]);
			if (Integer.parseInt(nums[i]) < 0) {
				negatives = negatives + nums[i] + " ";
			}
		    //ignores numbers over 1000
			if (Integer.parseInt(nums[i]) > 1000) {
				continue;
			}
			sum += Integer.parseInt(nums[i]);
		}
		if (!negatives.isEmpty()) {
			throw new Exception("Negatives not allowed: " + negatives);
		}
		return sum;
	}
}
