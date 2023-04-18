package com.tekgs.nextgen.igloo.user.cart;

import org.softwareonpurpose.softwaregauntlet.GauntletTest;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Service.USER, GauntletTest.Endpoint.CART})
public class CartResponseTests extends GauntletTest {
    @Test(groups = {TestSuite.SMOKE, TestSuite.RELEASE, TestSuite.DEBUG})
    public void smoke() {
        addRequirements("264 - Cart");
        CartResponseExpected expected = CartResponseExpected.getInstance();
        CartResponse actual = CartRequest.getInstance().get();
        then(CartResponseCalibrator.getInstance(expected, actual));
    }
}
