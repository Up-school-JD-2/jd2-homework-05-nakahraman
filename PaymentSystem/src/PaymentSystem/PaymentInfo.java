package PaymentSystem;

import java.util.Random;

import Constants.Message;
import Constants.Regex;

public class PaymentInfo extends PaymentSystem {

	private String paymentAmount;

	public void applyPaymentAmount() {

		do {
			paymentAmount = getInput(Message.ENTER_PAYMENT_AMOUNT);	

			try {
				if (checkRegex(Regex.PAYMENT_AMOUNT_REGEX, paymentAmount)) {
					throw new InvalidAmountException(Message.INVALID_PAYMENT_AMOUNT);
				}
			} catch (InvalidAmountException e) {
				System.err.println(e.getMessage());
			}
		} while (invalidInput);
		
		setPaymentAmount(paymentAmount);
	}

	public void pay(int i) {

		Random rand = new Random();
		Integer randomNumber = rand.nextInt(100);

		try {
			if (randomNumber > 75) {
				throw new SystemNotWorkingException(Message.SYSTEM_IS_NOT_WORKING);
			} else {
				System.out.println("--------------------------------------------------");
				System.out.println(Message.PAYMENT_COMPLETED);
				System.out.println("--------------------------------------------------");
			}
		} catch (SystemNotWorkingException e) {

			System.err.println(e.getMessage());

			if (i != 0) {
				System.err.println("Re-trying Payment...");
				pay(i - 1);
			}
		}
	}

	private void setPaymentAmount(String paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getPaymentAmount() {
		return paymentAmount;
	}
}
