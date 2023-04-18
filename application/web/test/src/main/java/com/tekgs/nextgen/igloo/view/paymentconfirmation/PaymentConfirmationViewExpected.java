package com.tekgs.nextgen.igloo.view.paymentconfirmation;

public class PaymentConfirmationViewExpected implements PaymentConfirmationViewCalibratable {
    private final PaymentResponseDefinition paymentResponse;
    private PaymentConfirmationCopy copy;

    private PaymentConfirmationViewExpected(PaymentResponseDefinition paymentResponse) {
        this.paymentResponse = paymentResponse;
    }

    public static PaymentConfirmationViewExpected getInstance(PaymentResponseDefinition paymentResponse) {
        return new PaymentConfirmationViewExpected(paymentResponse);
    }

    @Override
    public String getPaymentConfirmationMessage() {
        return "Succeeded".equals(paymentResponse.getStatus()) ? getCopy().getSuccessMessage() : "";
    }

    private PaymentConfirmationCopy getCopy() {
        if (copy == null) {
            copy = PaymentConfirmationCopy.getInstance();
        }
        return copy;
    }
}
