package com.tekgs.nextgen.igloo.view.paymentsubmission;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.softwareonpurpose.uinavigator.web.WebUiHost;
import com.tekgs.nextgen.igloo.data.product.Product;
import com.tekgs.nextgen.igloo.view.IglooView;
import com.tekgs.nextgen.igloo.view.paymentsubmission.form.PaymentSubmissionForm;

public class PaymentSubmissionView extends IglooView implements PaymentSubmissionViewCalibratable{
    private static final String RELATIVE_URI = "payment-submission";
    private static final String LOCATOR_VALUE = "payment-view-submission";
    private static final String DESCRIPTION = "'Payment Submission' View";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;

    public PaymentSubmissionView() {
        super(RELATIVE_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static PaymentSubmissionView directNav(Product product) {
        String relativeUri = String.format("?amount=%d", product.getPrice());
        new PaymentSubmissionView().load(relativeUri);
        return UiView.expect(PaymentSubmissionView.class);
    }

    @Override
    public PaymentSubmissionForm inFormRegion() {
        return PaymentSubmissionForm.getInstance(this.getElement());
    }

    @Override
    public String getTotalAmount() {
        return getTotalAmountElement().getText();
    }

    public UiElement getTotalAmountElement() {
        return getViewElementById("Total Amount", "payment-total");
    }

    @Override
    protected boolean confirmElementStates() {
        return WebUiHost.getInstance().getAddress().contains(RELATIVE_URI);
    }

}
