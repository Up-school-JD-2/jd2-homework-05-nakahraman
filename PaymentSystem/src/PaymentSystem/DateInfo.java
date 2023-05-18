package PaymentSystem;

import java.util.Calendar;

import Constants.Message;
import Constants.Regex;

public class DateInfo extends PaymentSystem {

	private String year;
	private String month;
	private String date;

	public void applyDate() {

		enterMonth();
		enterYear();
		validateDate();
	}

	private void enterMonth() {

		do {
			month = getInput(Message.ENTER_MONTH);

			try {
				validateMonth(month);
			} catch (InvalidDateException e) {
				System.err.println(e.getMessage());
			}
		} while (invalidInput);
		
		setMonth(month);
	}

	private void enterYear() {

		do {
			year = getInput(Message.ENTER_YEAR);

			try {
				validateYear(year);
			} catch (InvalidDateException e) {
				System.err.println(e.getMessage());
			}
		} while (invalidInput);
		
		setYear(year);
	}

	private void validateMonth(String month) throws InvalidDateException {

		if (checkRegex(Regex.MONTH_REGEX, month)) {
			throw new InvalidDateException(Message.INVALID_MONTH);
		}
	}

	private void validateYear(String year) throws InvalidDateException {

		if (checkRegex(Regex.YEAR_REGEX, year)) {
			throw new InvalidDateException(Message.INVALID_YEAR);
		}

		Calendar now = Calendar.getInstance();
		int currentYear = now.get(Calendar.YEAR);
		int cardYear = Integer.parseInt(year);

		if (cardYear < currentYear) {
			invalidInput = true;
			throw new InvalidDateException(Message.EXPIRED_YEAR);
		}
	}

	private void validateDate() {

		Calendar now = Calendar.getInstance();
		int currentMonth = now.get(Calendar.MONTH);
		int currentYear = now.get(Calendar.YEAR);
		
		do {
			try {
				if (Integer.parseInt(getMonth()) <= currentMonth && Integer.parseInt(getYear()) == currentYear) {
					invalidInput = true;
					throw new InvalidDateException(Message.EXPIRED_DATE + " -> " + getDate());
				}
			} catch (InvalidDateException e) {
				System.err.println(e.getMessage());
				enterMonth();
			}
		} while (invalidInput);

		setDate(getMonth() + "/" + getYear());
	}
	

	private String getYear() {
		return year;
	}

	private void setYear(String year) {
		this.year = year;
	}

	private String getMonth() {
		return month;
	}

	private void setMonth(String month) {
		this.month = month;
	}

	private void setDate(String date) {
		this.date = date;
	}

	public String getDate() {
		return date;
	}
	

}
