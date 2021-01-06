package stringcalculator;

public class StringCalculator {
	
	public static int add(String str) throws Exception {
		String[] operators = new String[] {"-","\\+","/","\\*","x","\\^","X"};
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
			String[] nums = str.split(delimiter);
			return sumFunction(nums);
		}
	}
	
	public static int sumFunction(String ...nums) throws Exception {
		int sum = 0;
		String negatives = "";
		for(int i = 0; i < nums.length; i++) {
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
