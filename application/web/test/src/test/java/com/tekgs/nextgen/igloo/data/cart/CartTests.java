package com.tekgs.nextgen.igloo.data.cart;

import com.tekgs.nextgen.igloo.data.cart.Cart;
import com.tekgs.nextgen.igloo.data.cart.CartCalibrator;
import com.tekgs.nextgen.igloo.data.cart.CartDefinition;
import com.tekgs.nextgen.igloo.data.cart.CartProvider;
import com.tekgs.nextgen.igloo.data.cart.item.CartItemCalibratable;
import com.tekgs.nextgen.igloo.data.cart.item.CartItemDefinition;
import com.tekgs.nextgen.igloo.data.cart.item.CartItemExpected;
import com.tekgs.nextgen.igloo.data.product.ProductCalibratable;
import com.tekgs.nextgen.igloo.view.cart.CartExpected;
import com.tekgs.nextgen.igloo.view.cart.CartView;
import org.softwareonpurpose.softwaregauntlet.GauntletTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Test(groups = {GauntletTest.Application.IGLOO, GauntletTest.Data.CART})
public class CartTests extends GauntletTest {
    @Test(groups = {TestSuite.SMOKE})
    public void smoke() {
        Cart cart = CartProvider.getInstance().get();
        CartExpected expected = CartExpected.getInstance(cart);
        Cart actual = CartProvider.getInstance().get(cart);
        then(CartCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.RELEASE, TestSuite.ACCEPTANCE}, dependsOnMethods = "smoke")
    public void incrementItems() {
        addRequirements("84 - Shopping Cart", "264 - Cart");
        CartDefinition cartDefinition = CartDefinition.getInstance().withItem(CartItemDefinition.getInstance());
        Cart cart = CartProvider.getInstance().get(cartDefinition);
        given(cart);
        int oneMore = 1;
        List<CartItemCalibratable> expectedItems = new ArrayList<>(cart.getItems());
        CartItemCalibratable cartItem = expectedItems.get(0);
        ProductCalibratable product = cartItem.getProduct();
        int newQuantity = cartItem.getQuantity() + oneMore;
        int itemIndex = expectedItems.indexOf(cartItem);
        expectedItems.set(itemIndex, CartItemExpected.getInstance(product, newQuantity));
        CartExpected expected = CartExpected.getInstance(cart, expectedItems);
        when();
        CartView.directNav(cart).inCartItemsRegion().increment(product);
        Cart actual = CartProvider.getInstance().get(cart);
        then(CartCalibrator.getInstance(expected, actual));
    }

    @Test(groups = {TestSuite.RELEASE, TestSuite.ACCEPTANCE, TestSuite.DEBUG}, dependsOnMethods = "smoke")
    public void decrementItems() {
        addRequirements("84 - Shopping Cart", "264 - Cart");
        CartDefinition cartDefinition = CartDefinition.getInstance().withItem(CartItemDefinition.getInstance());
        Cart cart = CartProvider.getInstance().get(cartDefinition);
        int decrement = 1;
        List<CartItemCalibratable> expectedItems = new ArrayList<>(cart.getItems());
        CartItemCalibratable cartItem = expectedItems.get(0);
        ProductCalibratable product = cartItem.getProduct();
        given(cart);
        int newQuantity = cartItem.getQuantity() - decrement;
        int itemIndex = expectedItems.indexOf(cartItem);
        expectedItems.set(itemIndex, CartItemExpected.getInstance(product, newQuantity));
        CartExpected expected = CartExpected.getInstance(cart, expectedItems);
        when();
        CartView.directNav(cart).inCartItemsRegion().decrement(product);
        Cart actual = CartProvider.getInstance().get(cart);
        then(CartCalibrator.getInstance(expected, actual));
    }
}
