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
			if(str.contains("\n")) {
				str = str.replaceAll("\n", ","); //removes new line operator
			}
			String[] nums = str.split(",");
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
