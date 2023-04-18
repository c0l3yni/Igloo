package com.tekgs.nextgen.igloo.view.paymentsubmission.form;

public class PaymentSubmissionFormExpected implements PaymentSubmissionFormCalibratable {
    public static PaymentSubmissionFormExpected getInstance() {
        return new PaymentSubmissionFormExpected();
    }

    @Override
    public Boolean isCurrencyDisplayed() {
        return true;
    }

    @Override
    public Boolean isSourceDisplayed() {
        return true;
    }
}
