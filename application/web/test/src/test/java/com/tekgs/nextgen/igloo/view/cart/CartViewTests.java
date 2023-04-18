package com.tekgs.nextgen.igloo.view.cart;

import com.tekgs.nextgen.igloo.data.cart.Cart;
import com.tekgs.nextgen.igloo.data.cart.CartDefinition;
import com.tekgs.nextgen.igloo.data.cart.CartProvider;
import com.tekgs.nextgen.igloo.data.cart.item.CartItemCalibratable;
import com.tekgs.nextgen.igloo.data.cart.item.CartItemDefinition;
import com.tekgs.nextgen.igloo.data.product.ProductCalibratable;
import com.tekgs.nextgen.igloo.data.product.ProductDefinition;
import org.softwareonpurpose.softwaregauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test(groups = {GauntletTest.Application.IGLOO, GauntletTest.View.CART})
public class CartViewTests extends GauntletTest {
    private static final ProductDefinition productAny = ProductDefinition.getInstance();
    private static final ProductCalibratable productWithPriceOfTwoCents = ProductDefinition.getInstance().withPrice(2);
    private static final CartItemDefinition itemWithAtLeastOneProduct = CartItemDefinition.getInstance().withProduct(productAny);
    private static final CartItemCalibratable itemWithProductPriceOfTwoCents = CartItemDefinition.getInstance().withProduct(productWithPriceOfTwoCents);

    @DataProvider
    public static Object[][] scenarios() {
        return new Object[][]{
                {CartDefinition.getInstance().withItem(itemWithAtLeastOneProduct)},
                {CartDefinition.getInstance().withItem(itemWithProductPriceOfTwoCents)}
        };
    }

    @Test(groups = {TestSuite.SMOKE, TestSuite.RELEASE})
    public void smoke() {
        addRequirements("81 - Load Times");
        CartViewExpected expected = CartViewExpected.getInstance();
        CartView actual = CartView.directNav();
        then(CartViewCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.ACCEPTANCE, TestSuite.DEBUG}, dependsOnMethods = "smoke", dataProvider = "scenarios")
    public void directNav(CartDefinition cartDefinition) {
        addRequirements("81 - Load Times");
        Cart cart = CartProvider.getInstance().get(cartDefinition);
        given(cart);
        CartViewExpected expected = CartViewExpected.getInstance(cart);
        when();
        CartView actual = CartView.directNav(cart);
        then(CartViewCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.RELEASE}, dependsOnMethods = "smoke")
    public void release() {
        addRequirements("81 - Load Times");
        CartDefinition cartDefinition = CartDefinition.getInstance().withItem(itemWithAtLeastOneProduct);
        Cart cart = CartProvider.getInstance().get(cartDefinition);
        given(cart);
        CartViewExpected expected = CartViewExpected.getInstance(cart);
        when();
        CartView actual = CartView.directNav(cart);
        then(CartViewCalibrator.getInstance(expected, actual));
    }
}
