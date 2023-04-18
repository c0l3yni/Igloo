package com.tekgs.nextgen.igloo.view.paymentsubmission;

import com.tekgs.nextgen.igloo.data.product.Product;
import com.tekgs.nextgen.igloo.view.paymentsubmission.form.PaymentSubmissionFormExpected;

public class PaymentSubmissionViewExpected implements PaymentSubmissionViewCalibratable {
    private final Product item;

    public PaymentSubmissionViewExpected(Product item) {
        this.item = item;
    }

    public static PaymentSubmissionViewExpected getInstance(Product item) {
        return new PaymentSubmissionViewExpected(item);
    }

    public String getTotalAmount() {
        double centToDollars = (double) item.getPrice() / 100;
        return String.format("$%.2f", centToDollars);
    }

    @Override
    public PaymentSubmissionFormExpected inFormRegion() {
        return PaymentSubmissionFormExpected.getInstance();
    }
}
