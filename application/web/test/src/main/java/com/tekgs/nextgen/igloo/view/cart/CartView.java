package com.tekgs.nextgen.igloo.view.cart;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiView;
import com.softwareonpurpose.uinavigator.web.WebUiHost;
import com.tekgs.nextgen.igloo.data.cart.Cart;
import com.tekgs.nextgen.igloo.view.IglooView;
import com.tekgs.nextgen.igloo.view.cart.items.CartItemsRegion;

public class CartView extends IglooView implements CartViewCalibratable {
    private static final String RELATIVE_URI = "cart";
    private static final String DESCRIPTION = "'Cart' view";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "cart-view";

    public CartView() {
        super(RELATIVE_URI, UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE));
    }

    public static CartView directNav(Cart cart) {
        new CartView().load(cart.getId() == null ? "" : String.format("?id=%s", cart.getId()));
        return UiView.expect(CartView.class);
    }

    public static CartView directNav() {
        new CartView().load();
        return UiView.expect(CartView.class);
    }

    @Override
    protected boolean confirmElementStates() {
        return WebUiHost.getInstance().getAddress().contains(RELATIVE_URI);
    }

    @Override
    public Boolean isPaymentEnabled() {
        return getPaymentButtonElement().getAttribute("class").contains("button-enabled");
    }

    @Override
    public String getTotalFormatted() {
        return getTotalAmountElement().getText();
    }

    @Override
    public CartItemsRegion inCartItemsRegion() {
        return CartItemsRegion.getInstance(this.getElement());
    }

    private UiElement getTotalAmountElement() {
        String description = "Total Amount";
        String locatorValue = "cart-total";
        return getViewElementById(description, locatorValue);
    }

    private UiElement getPaymentButtonElement() {
        String description = "'Payment' button";
        String locatorValue = "submit-payment";
        return getViewElementById(description, locatorValue);
    }

}
