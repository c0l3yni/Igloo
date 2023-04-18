package com.tekgs.nextgen.igloo.view.cart.item.product;

import com.softwareonpurpose.uinavigator.UiElement;
import com.softwareonpurpose.uinavigator.UiLocatorType;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.igloo.data.product.ProductCalibratable;
import com.tekgs.nextgen.igloo.data.product.ProductDefinition;

public class ProductRegion extends UiRegion implements ProductRegionCalibratable {
    private static final String DESCRIPTION = "'Product' region";
    private static final String LOCATOR_TYPE = UiLocatorType.CLASS;
    private static final String LOCATOR_VALUE = "product";

    private ProductRegion(UiElement parent) {
        super(UiElement.getInstance(DESCRIPTION, LOCATOR_TYPE, LOCATOR_VALUE, parent));
    }

    public static ProductRegion getInstance(UiElement parent) {
        return new ProductRegion(parent);
    }

    @Override
    public ProductCalibratable getProduct() {
        return ProductDefinition.getInstance()
                .withDescription(getDescription())
                .withPrice(getPriceInCents())
                .withId(getProductId());
    }

    @Override
    public String getPrice() {
        return getPriceElement().getText();
    }

    private String getProductId() {
        return this.getElement().getAttribute("data-id");
    }

    @Override
    public String getDescription() {
        return getDescriptionElement().getText();
    }

    private int getPriceInCents() {
        String priceAsNumbersOnly = getPriceElement().getText().replace("$", "").replace(".", "");
        return Integer.parseInt(priceAsNumbersOnly);
    }

    private UiElement getPriceElement() {
        return UiElement.getInstance("Price", UiLocatorType.CLASS, "product-price", this.getElement());
    }

    private UiElement getDescriptionElement() {
        return UiElement.getInstance("Description", UiLocatorType.CLASS, "product-description", this.getElement());
    }
}
