package com.tekgs.nextgen.igloo.view.cart;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.tekgs.nextgen.igloo.view.cart.items.CartItemsRegionCalibrator;

public class CartViewCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Cart' view";
    private final CartView actual;
    private final CartViewExpected expected;

    private CartViewCalibrator(CartViewExpected expected, CartView actual) {
        super(DESCRIPTION, expected, actual);
        this.actual = actual;
        this.expected = expected;
        addChildCalibrator(CartItemsRegionCalibrator.getInstance(expected.inCartItemsRegion(), actual.inCartItemsRegion()));
    }

    public static CartViewCalibrator getInstance(CartViewExpected expected, CartView actual) {
        return new CartViewCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Is 'Payment' button enabled", expected.isPaymentEnabled(), actual.isPaymentEnabled());
        verify("Total Amount", expected.getTotalFormatted(), actual.getTotalFormatted());
    }
}
