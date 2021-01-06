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
			String[] nums = str.split(",");
			return Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]);
		}
	}
}
