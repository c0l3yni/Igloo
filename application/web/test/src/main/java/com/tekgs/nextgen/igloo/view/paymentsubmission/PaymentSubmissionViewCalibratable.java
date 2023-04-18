package com.tekgs.nextgen.igloo.view.paymentsubmission;

import com.tekgs.nextgen.igloo.view.paymentsubmission.form.PaymentSubmissionFormCalibratable;

public interface PaymentSubmissionViewCalibratable {
    String getTotalAmount();
    PaymentSubmissionFormCalibratable inFormRegion();
}
