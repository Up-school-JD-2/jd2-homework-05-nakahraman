package PaymentSystem;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaymentSystem implements Payment {

	public boolean invalidInput;

	@Override
	public boolean checkRegex(String regex, String valueToBeChecked) {

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(valueToBeChecked);
		if (!(matcher.matches())) {
			invalidInput = true;
		}
		return invalidInput;
	}

	@Override
	public String getInput(String entry) {

		Scanner scan = new Scanner(System.in);
		System.out.println(entry);
		invalidInput = false;
		return scan.next();
	}
}
