package PaymentSystem;

public class PaymentManager extends PaymentSystem {

	public static void main(String[] args) {

		PaymentInfo paymentInfo = new PaymentInfo();
		paymentInfo.applyPaymentAmount();

		DateInfo dateInfo = new DateInfo();
		dateInfo.applyDate();

		CreditCardInfo creditCard = new CreditCardInfo();
		creditCard.enterCreditCardNumber();
		creditCard.enterSecurityNumber();

		int repeatAfterFailure = 1;
		paymentInfo.pay(repeatAfterFailure);

		System.out.println();
		System.out.println("*** PAYMENT DETAILS ***");
		System.out.println("Payment Amount: $" + Double.parseDouble(paymentInfo.getPaymentAmount()));
		System.out.println("Credit Card Number: " + creditCard.getCardNumber());
		System.out.println("Security Number: " + creditCard.getSecurityNumber());
		System.out.println("Card Validity Date: " + dateInfo.getDate());
	}

}
