package PaymentSystem;

import Constants.Message;
import Constants.Regex;

public class CreditCardInfo extends PaymentSystem {
	private String cardNumber;
	private String securityNumber;

	public void enterCreditCardNumber() {

		do {
			cardNumber = getInput(Message.ENTER_CARD_NUMBER);
			
			try {
				validateNumber(Regex.CARD_NUMBER_REGEX, cardNumber);
			} catch (InvalidNumberException e) {
				System.err.println(e.getMessage());
			}
		} while (invalidInput);
		
		setCardNumber(cardNumber);
	}

	public void enterSecurityNumber() {

		do {
			securityNumber = getInput(Message.ENTER_SECURITY_NUMBER);
			
			try {
				validateNumber(Regex.SECURITY_NUMBER_REGEX, securityNumber);
			} catch (InvalidNumberException e) {
				System.err.println(e.getMessage());
			}
		} while (invalidInput);
		
		setSecurityNumber(securityNumber);
	}

	private void validateNumber(String regex, String number) throws InvalidNumberException {

		if (checkRegex(regex, number)) {
			throw new InvalidNumberException(Message.INVALID_NUMBER);
		}
	}


	private void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public String getCardNumber() {
		return cardNumber;
	}

	private void setSecurityNumber(String securityNumber) {
		this.securityNumber = securityNumber;
	}

	public String getSecurityNumber() {
		return securityNumber;
	}

}
