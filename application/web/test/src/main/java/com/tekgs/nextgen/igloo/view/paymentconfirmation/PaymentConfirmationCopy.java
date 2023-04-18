package com.tekgs.nextgen.igloo.view.paymentconfirmation;

import com.tekgs.nextgen.igloo.copy.IglooCopySource;

public class PaymentConfirmationCopy {
    private IglooCopySource copy;

    public static PaymentConfirmationCopy getInstance() {
        return new PaymentConfirmationCopy();
    }

    public String getSuccessMessage() {
        return getCopy().getSuccessMessage();
    }

    private IglooCopySource getCopy() {
        if(copy==null){
            copy= IglooCopySource.getInstance();
        }
        return copy;
    }
}
