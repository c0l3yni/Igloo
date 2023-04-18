package com.tekgs.nextgen.igloo.view.paymentconfirmation;

public class PaymentResponseDefinition {
    private String status;

    public static PaymentResponseDefinition getInstance() {
        return new PaymentResponseDefinition();
    }

    public PaymentResponseDefinition withStatus(String status) {
        this.status = status;
        return this;
    }

    public String getStatus() {
        return status;
    }
}
