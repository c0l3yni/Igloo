package com.tekgs.nextgen.igloo.view.cart.items;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.softwareonpurpose.uinavigator.UiView;
import com.tekgs.nextgen.igloo.data.product.ProductCalibratable;
import com.tekgs.nextgen.igloo.view.cart.CartView;
import com.tekgs.nextgen.igloo.view.cart.item.CartItemRegion;
import com.tekgs.nextgen.igloo.view.cart.item.CartItemRegionCalibratable;

import java.util.ArrayList;
import java.util.List;

public class CartItemsRegion extends UiRegion implements CartItemsRegionCalibratable {
    private static final String DESCRIPTION = "'Cart Items' region";
    private static final String LOCATOR_TYPE = UiLocatorType.ID;
    private static final String LOCATOR_VALUE = "items-region";

    private CartItemsRegion(UiElement parentElement) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parentElement));
    }

    public static CartItemsRegion getInstance(UiElement parent) {
        return new CartItemsRegion(parent);
    }

    @Override
    public List<CartItemRegionCalibratable> getItems() {
        List<CartItemRegionCalibratable> items = new ArrayList<>();
        String description = "Item";
        String locatorValue = "item";
        List<UiElement> itemElements = UiElement.getList(description, UiLocatorType.CLASS, locatorValue, this.getElement());
        for (UiElement itemElement : itemElements) {
            items.add(CartItemRegion.getInstance(itemElement));
        }
        return items;
    }

    @SuppressWarnings("UnusedReturnValue")
    public CartView increment(ProductCalibratable product) {
        for (CartItemRegionCalibratable candidate : getItems()) {
            if (candidate.inProductRegion().getProduct().equivalent(product)) {
                return ((CartItemRegion) candidate).increment();
            }
        }
        return UiView.expect(CartView.class);
    }

    @SuppressWarnings("UnusedReturnValue")
    public CartView decrement(ProductCalibratable product) {
        for (CartItemRegionCalibratable candidate : getItems()) {
            if (candidate.inProductRegion().getProduct().equivalent(product)) {
                return ((CartItemRegion) candidate).decrement();
            }
        }
        return UiView.expect(CartView.class);
    }
}
