package Constants;

public class Regex {
	
	private Regex() {}
	
	public static final String MONTH_REGEX = "^(0[1-9]|1[0-2])";
	public static final String YEAR_REGEX = "\\d{4}";
	public static final String CARD_NUMBER_REGEX = "\\d{16}";
	public static final String SECURITY_NUMBER_REGEX = "\\d{3}";
	public static final String PAYMENT_AMOUNT_REGEX = "\\d+(\\.\\d+)?";
}
