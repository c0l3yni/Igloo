package com.tekgs.nextgen.igloo.view.cart.item;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.tekgs.nextgen.igloo.view.cart.item.product.ProductRegionCalibrator;

public class CartItemRegionCalibrator extends Calibrator {

    private static final String DESCRIPTION = "'Cart Item' region";
    private final CartItemRegionCalibratable actual;
    private final CartItemRegionCalibratable expected;

    public CartItemRegionCalibrator(CartItemRegionCalibratable expected, CartItemRegionCalibratable actual) {
        super(DESCRIPTION, expected, actual);
        this.actual = actual;
        this.expected = expected;
        addChildCalibrator(ProductRegionCalibrator.getInstance(expected.inProductRegion(), actual.inProductRegion()));
    }

    public static CartItemRegionCalibrator getInstance(CartItemRegionCalibratable expected, CartItemRegionCalibratable actual) {
        return new CartItemRegionCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Quantity", expected.getQuantity(), actual.getQuantity());
        verify("'Increment' button exists", expected.isIncrementButtonDisplayed(), actual.isIncrementButtonDisplayed());
        verify("'Decrement' button exists", expected.isDecrementButtonDisplayed(), actual.isDecrementButtonDisplayed());
    }
}
