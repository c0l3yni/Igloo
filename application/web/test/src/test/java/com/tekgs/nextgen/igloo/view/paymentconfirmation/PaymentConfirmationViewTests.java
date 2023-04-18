package com.tekgs.nextgen.igloo.view.paymentconfirmation;

import org.softwareonpurpose.softwaregauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PaymentConfirmationViewTests extends GauntletTest {
    @DataProvider
    public static Object[][] scenarios() {
        return new Object[][]{
                {PaymentResponseDefinition.getInstance().withStatus("Succeeded")},
                {PaymentResponseDefinition.getInstance().withStatus("Failed")},
        };
    }

    @Test(groups = {TestSuite.SMOKE, TestSuite.RELEASE})
    public void smoke() {
        addRequirements("81 - Load Times");
        PaymentResponseDefinition paymentResponse = PaymentResponseDefinition.getInstance().withStatus("Succeeded");
        given(paymentResponse);
        PaymentConfirmationViewExpected expected = PaymentConfirmationViewExpected.getInstance(paymentResponse);
        when();
        PaymentConfirmationView actual = PaymentConfirmationView.directNav(paymentResponse);
        then(PaymentConfirmationViewCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.RELEASE}, dependsOnMethods = "smoke", dataProvider = "scenarios")
    public void directNav(PaymentResponseDefinition paymentResponse) {
        addRequirements("81 - Load Times");
        given(paymentResponse);
        PaymentConfirmationViewExpected expected = PaymentConfirmationViewExpected.getInstance(paymentResponse);
        when();
        PaymentConfirmationView actual = PaymentConfirmationView.directNav(paymentResponse);
        then(PaymentConfirmationViewCalibrator.getInstance(expected, actual));
    }
}
