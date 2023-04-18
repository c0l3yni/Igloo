package com.tekgs.nextgen.igloo.view.cart.items;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.softwareonpurpose.uinavigator.UiRegion;
import com.tekgs.nextgen.igloo.view.cart.item.CartItemRegionCalibratable;
import com.tekgs.nextgen.igloo.view.cart.item.CartItemRegionCalibrator;

import java.util.List;

public class CartItemsRegionCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Cart Items' region";

    private CartItemsRegionCalibrator(CartItemsRegionCalibratable expected, CartItemsRegionCalibratable actual) {
        super(DESCRIPTION, expected, actual);
        UiRegion.suppressConstructionLogging(true);
        List<CartItemRegionCalibratable> itemsExpected = expected.getItems();
        List<CartItemRegionCalibratable> itemsActual = actual.getItems();
        addCalibrationsExpected(itemsExpected, itemsActual);
        addCalibrationsUnexpected(itemsActual);
        UiRegion.suppressConstructionLogging(false);
    }

    private void addCalibrationsExpected(List<CartItemRegionCalibratable> itemsExpected, List<CartItemRegionCalibratable> itemsActual) {
        for (CartItemRegionCalibratable itemExpected : itemsExpected) {
            CartItemRegionCalibratable itemFound = addCalibrationFoundItem(itemsActual, itemExpected);
            if (itemFound != null) {
                itemsActual.remove(itemFound);
            } else {
                addChildCalibrator(CartItemRegionCalibrator.getInstance(itemExpected, null));
            }
        }
    }

    private CartItemRegionCalibratable addCalibrationFoundItem(List<CartItemRegionCalibratable> itemsActual, CartItemRegionCalibratable itemExpected) {
        CartItemRegionCalibratable itemFound = null;
        for (CartItemRegionCalibratable itemActual : itemsActual) {
            if (itemActual.equivalent(itemExpected)) {
                itemFound = itemActual;
                addChildCalibrator(CartItemRegionCalibrator.getInstance(itemExpected, itemActual));
                break;
            }
        }
        return itemFound;
    }

    private void addCalibrationsUnexpected(List<CartItemRegionCalibratable> itemsActual) {
        for (CartItemRegionCalibratable itemActual : itemsActual) {
            addChildCalibrator(CartItemRegionCalibrator.getInstance(null, itemActual));
        }
    }

    public static CartItemsRegionCalibrator getInstance(CartItemsRegionCalibratable expected, CartItemsRegionCalibratable actual) {
        return new CartItemsRegionCalibrator(expected, actual);
    }

    @Override
    protected void executeVerifications() {
    }
}
