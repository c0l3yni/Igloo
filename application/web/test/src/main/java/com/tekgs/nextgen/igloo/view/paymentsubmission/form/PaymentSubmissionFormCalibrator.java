package com.tekgs.nextgen.igloo.view.paymentsubmission.form;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class PaymentSubmissionFormCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Form' region";
    private final PaymentSubmissionFormExpected expected;
    private final PaymentSubmissionForm actual;

    public PaymentSubmissionFormCalibrator(PaymentSubmissionFormExpected expected, PaymentSubmissionForm actual) {
        super(DESCRIPTION, expected, actual);
        this.actual = actual;
        this.expected = expected;
    }

    public static PaymentSubmissionFormCalibrator getInstance(PaymentSubmissionFormExpected expected, PaymentSubmissionForm actual) {
        return new PaymentSubmissionFormCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Source Displayed", expected.isSourceDisplayed(), actual.isSourceDisplayed());
        verify("Currency Displayed", expected.isCurrencyDisplayed(), actual.isCurrencyDisplayed());
    }
}
