package com.tekgs.nextgen.igloo.view.paymentsubmission;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.tekgs.nextgen.igloo.view.paymentsubmission.form.PaymentSubmissionFormCalibrator;

public class PaymentSubmissionViewCalibrator extends Calibrator {
    private final PaymentSubmissionView actual;
    private final PaymentSubmissionViewExpected expected;
    private static final String DESCRIPTION = "'Payment Submission' View";
    protected PaymentSubmissionViewCalibrator(PaymentSubmissionViewExpected expected, PaymentSubmissionView actual) {
        super(DESCRIPTION, expected, actual);
        this.actual = actual;
        this.expected = expected;
        addChildCalibrator(PaymentSubmissionFormCalibrator.getInstance(expected.inFormRegion(), actual.inFormRegion()));
    }
    public static PaymentSubmissionViewCalibrator getInstance(PaymentSubmissionViewExpected expected, PaymentSubmissionView actual){
        return new PaymentSubmissionViewCalibrator(expected, actual);
    }
    @Override
    protected void executeVerifications() {
        verify("Total Amount", expected.getTotalAmount(), actual.getTotalAmount());
    }
}
