package com.tekgs.nextgen.igloo.view.paymentsubmission.form;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.tekgs.nextgen.igloo.view.IglooRegion;

public class PaymentSubmissionForm extends IglooRegion implements PaymentSubmissionFormCalibratable {
    private static final String DESCRIPTION = "'Form' region";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "payment-form";

    protected PaymentSubmissionForm(UiElement parentElement) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parentElement));
    }

    public static PaymentSubmissionForm getInstance(UiElement parent) {
        return new PaymentSubmissionForm(parent);
    }

    public UiElement getSourceElement(){
        String description = "Source Element";
        String locatorId = "source";
        return getRegionElementByName(description,locatorId);
    }

    private UiElement getCurrencyElement() {
        String description = "Currency Element";
        String locatorId = "currency";
        return getRegionElementByName(description,locatorId);
    }

    @Override
    public Boolean isCurrencyDisplayed() {
        return getCurrencyElement().isDisplayed();
    }

    @Override
    public Boolean isSourceDisplayed() {
        return getSourceElement().isDisplayed();
    }
}
