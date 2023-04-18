package com.tekgs.nextgen.igloo.data.cart.item;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class CartItemCalibrator extends Calibrator {

    private static final String DESCRIPTION = "Cart Item";
    private final CartItemCalibratable expected;
    private final CartItemCalibratable actual;

    protected CartItemCalibrator(CartItemCalibratable expected, CartItemCalibratable actual) {
        super(DESCRIPTION, expected, actual);
        this.expected = expected;
        this.actual = actual;
    }

    public static CartItemCalibrator getInstance(CartItemCalibratable expected,CartItemCalibratable actual) {
        return new CartItemCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Item quantity", expected.getQuantity(), actual.getQuantity());
        verify("Product Price", expected.getProduct().getPrice(), actual.getProduct().getPrice());
        verify("Product Description", expected.getProduct().getDescription(), actual.getProduct().getDescription());
    }
}
