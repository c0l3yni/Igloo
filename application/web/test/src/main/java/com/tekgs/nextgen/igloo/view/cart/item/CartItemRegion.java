package com.tekgs.nextgen.igloo.view.cart.item;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.igloo.view.cart.CartView;
import com.tekgs.nextgen.igloo.view.cart.item.product.ProductRegion;
import com.tekgs.nextgen.igloo.view.cart.item.product.ProductRegionCalibratable;

import javax.swing.*;

import static java.lang.Integer.parseInt;

public class CartItemRegion extends UiRegion implements CartItemRegionCalibratable {
    protected CartItemRegion(UiElement itemElement) {
        super(itemElement);
    }

    public static CartItemRegion getInstance(UiElement itemElement) {
        return new CartItemRegion(itemElement);
    }

    @Override
    public String getItemDescription() {
        return inProductRegion().getProduct().getDescription();
    }

    @Override
    public boolean equivalent(CartItemRegionCalibratable comparator) {
        return comparator.getItemDescription() == null || this.getItemDescription().equals(comparator.getItemDescription());
    }

    @Override
    public Integer getQuantity() {
        return parseInt(getItemQuantityElement().getText());
    }

    private UiElement getPriceElement() {
        return UiElement.getInstance("Item Price", UiLocatorType.CLASS, "item-price", this.getElement());
    }

    @Override
    public Integer getPrice() {
        return parseInt(getPriceElement().getText());
    }

    @Override
    public Boolean isIncrementButtonDisplayed() {
        return getIncrementButtonElement().isDisplayed();
    }

    @Override
    public Boolean isDecrementButtonDisplayed() {
        return getDecrementButtonElement().isDisplayed();
    }

    @Override
    public ProductRegionCalibratable inProductRegion() {
        return ProductRegion.getInstance(this.getElement());
    }

    private UiElement getItemQuantityElement() {
        return UiElement.getInstance("Item Quantity", UiLocatorType.CLASS, "item-quantity", this.getElement());
    }

    private UiElement getIncrementButtonElement() {
        return UiElement.getInstance("'Increment' button", UiLocatorType.CLASS, "increment", this.getElement());
    }

    private UiElement getDecrementButtonElement() {
        return UiElement.getInstance("'Decrement' button", UiLocatorType.CLASS, "decrement", this.getElement());
    }

    public CartView increment() {
        getIncrementButtonElement().click();
        return UiView.expect(CartView.class);
    }

    public CartView decrement() {
        UiElement element = getDecrementButtonElement();
        System.out.printf("  Click '%s' element%n", element.getDescription());
        element.click();
        return UiView.expect(CartView.class);
    }
}
