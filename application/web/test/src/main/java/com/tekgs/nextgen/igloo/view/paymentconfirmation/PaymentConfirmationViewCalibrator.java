package com.tekgs.nextgen.igloo.view.paymentconfirmation;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.tekgs.nextgen.igloo.view.paymentsubmission.PaymentSubmissionViewExpected;

public class PaymentConfirmationViewCalibrator extends Calibrator {
    private final PaymentConfirmationView actual;
    private final PaymentConfirmationViewExpected expected;
    private static final String DESCRIPTION = "'Payment Confirmation' View";

    protected PaymentConfirmationViewCalibrator(PaymentConfirmationViewExpected expected, PaymentConfirmationView actual){
        super(DESCRIPTION, expected, actual);
        this.actual = actual;
        this.expected = expected;
    }
    public static PaymentConfirmationViewCalibrator getInstance(PaymentConfirmationViewExpected expected, PaymentConfirmationView actual){
        return new PaymentConfirmationViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        String paymentConfirmation = "'Payment Confirmation' Message";
        verify(paymentConfirmation, expected.getPaymentConfirmationMessage(), actual.getPaymentConfirmationMessage());
    }
}
