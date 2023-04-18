package com.stripe.api.v1.charges;

import org.softwareonpurpose.softwaregauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Service.STRIPE, GauntletTest.Endpoint.CHARGES})
public class ChargesTests extends GauntletTest {
    @DataProvider
    public static Object[][] scenarios() {
        return new Object[][]{
                {49},
                {50},
                {99999999},
                {100000000},
                {-50}
        };
    }

    @Test(groups = {TestSuite.SMOKE})
    public void smoke() {
        int amount = 50;
        ChargesResponseExpected expected = ChargesResponseExpected.getInstance(amount);
        ChargesResponse actual = ChargesRequest.getInstance(amount).post();
        then(ChargesResponseCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.ACCEPTANCE}, dependsOnMethods = "smoke", dataProvider = "scenarios")
    public void post(Integer amount){
        given(amount);
        ChargesResponseExpected expected = ChargesResponseExpected.getInstance(amount);
        ChargesResponse actual = ChargesRequest.getInstance(amount).post();
        then(ChargesResponseCalibrator.getInstance(expected, actual));
    }
}
