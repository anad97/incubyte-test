package stringcalculator;

public class StringCalculator {
	
	public static int add(String str) {
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
				int delimiterIndex = str.indexOf("//") + 2;
				delimiter = Character.toString(str.charAt(delimiterIndex));
				str = str.replaceAll("//" + delimiter, "");
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
	
	public static int sumFunction(String ...nums) {
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += Integer.parseInt(nums[i]);
		}
		return sum;
	}
}
