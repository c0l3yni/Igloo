package com.tekgs.nextgen.igloo.view.cart.item.product;

import com.softwareonpurpose.calibrator4test.Calibrator;

public class ProductRegionCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Product' region";
    private final ProductRegionCalibratable actual;
    private final ProductRegionCalibratable expected;

    private ProductRegionCalibrator(ProductRegionCalibratable expected, ProductRegionCalibratable actual) {
        super(DESCRIPTION, expected, actual);
        this.actual = actual;
        this.expected = expected;
    }

    public static ProductRegionCalibrator getInstance(ProductRegionCalibratable expected, ProductRegionCalibratable actual) {
        return new ProductRegionCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
        verify("Description", expected.getDescription(), actual.getDescription());
        verify("Price", expected.getPrice(), actual.getPrice());
    }
}
