package com.tekgs.nextgen.igloo.view.paymentsubmission;

import com.tekgs.nextgen.igloo.data.product.Product;
import com.tekgs.nextgen.igloo.data.product.ProductDefinition;
import com.tekgs.nextgen.igloo.data.product.ProductProvider;
import org.softwareonpurpose.softwaregauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.IGLOO, GauntletTest.View.PAYMENT_SUBMISSION})
public class PaymentSubmissionViewTests extends GauntletTest {
    @DataProvider
    public static Object[][] scenarios() {
        int positivePrice = 1;
        int zeroPrice = 0;
        int negativePrice = -1;
        int maxPrice = 2147483647;
        return new Object[][]{
                {ProductDefinition.getInstance().withPrice(positivePrice)}
                , {ProductDefinition.getInstance().withPrice(zeroPrice)}
                , {ProductDefinition.getInstance().withPrice(negativePrice)}
                , {ProductDefinition.getInstance().withPrice(maxPrice)}
        };
    }

    @Test(groups = {TestSuite.SMOKE, TestSuite.RELEASE})
    public void smoke() {
        addRequirements("81 - Load Times");
        Product product = ProductProvider.getInstance().get(ProductDefinition.getInstance().withPrice(1));
        PaymentSubmissionViewExpected expected = PaymentSubmissionViewExpected.getInstance(product);
        PaymentSubmissionView actual = PaymentSubmissionView.directNav(product);
        then(PaymentSubmissionViewCalibrator.getInstance(expected, actual));
    }

    @Test(dependsOnMethods = "smoke", dataProvider = "scenarios")
    public void directNav(ProductDefinition productDefinition) {
        addRequirements("81 - Load Times");
        Product product = ProductProvider.getInstance().get(productDefinition);
        PaymentSubmissionViewExpected expected = PaymentSubmissionViewExpected.getInstance(product);
        PaymentSubmissionView actual = PaymentSubmissionView.directNav(product);
        then(PaymentSubmissionViewCalibrator.getInstance(expected, actual));
    }

}
