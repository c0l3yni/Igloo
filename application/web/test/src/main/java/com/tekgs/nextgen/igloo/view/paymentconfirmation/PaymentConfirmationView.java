package com.tekgs.nextgen.igloo.view.paymentconfirmation;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.softwareonpurpose.uinavigator.web.WebUiHost;
import com.tekgs.nextgen.igloo.view.IglooView;

public class PaymentConfirmationView extends IglooView implements PaymentConfirmationViewCalibratable {
    private static final String RELATIVE_URI = "payment-confirmation";
    private static final String LOCATOR_VALUE = "payment-confirmation-view";
    private static final String DESCRIPTION = "'Payment Confirmation' View";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;

    public PaymentConfirmationView() {
        super(RELATIVE_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static PaymentConfirmationView directNav(PaymentResponseDefinition paymentResponse) {
        String relativeUri = String.format("?status=%s", paymentResponse.getStatus());
        new PaymentConfirmationView().load(relativeUri);
        return UiView.expect(PaymentConfirmationView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        return WebUiHost.getInstance().getAddress().contains(RELATIVE_URI);
    }

    @Override
    public String getPaymentConfirmationMessage() {
        return getPaymentConfirmationMessageElement().getText();
    }

    private UiElement getPaymentConfirmationMessageElement() {
        return getViewElementById("'Payment Confirmation' message", "confirmation-message");
    }
}
