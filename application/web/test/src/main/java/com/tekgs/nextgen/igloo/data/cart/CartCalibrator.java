package com.tekgs.nextgen.igloo.data.cart;

import com.softwareonpurpose.calibrator4test.Calibrator;
import com.tekgs.nextgen.igloo.data.cart.item.CartItemCalibratable;
import com.tekgs.nextgen.igloo.data.cart.item.CartItemCalibrator;
import com.tekgs.nextgen.igloo.view.cart.CartExpected;

import java.util.List;

public class CartCalibrator extends Calibrator {
    private static final String DESCRIPTION = "'Cart' record";

    private CartCalibrator(CartExpected expected, Cart actual) {
        super(DESCRIPTION, expected, actual);
        List<CartItemCalibratable> itemsExpected = expected.getItems();
        List<CartItemCalibratable> itemsActual = actual.getItems();
        addCalibrationsExpected(itemsExpected, itemsActual);
        addCalibrationsUnexpected(itemsActual);
    }

    public static CartCalibrator getInstance(CartExpected expected, Cart actual) {
        return new CartCalibrator(expected, actual);
    }

    private void addCalibrationsExpected(List<CartItemCalibratable> itemsExpected, List<CartItemCalibratable> itemsActual) {
        for (CartItemCalibratable itemExpected : itemsExpected) {
            CartItemCalibratable itemFound = addCalibrationFoundItem(itemsActual, itemExpected);
            if (itemFound != null) {
                itemsActual.remove(itemFound);
            } else {
                addChildCalibrator(CartItemCalibrator.getInstance(itemExpected, null));
            }
        }
    }

    private CartItemCalibratable addCalibrationFoundItem(List<CartItemCalibratable> itemsActual, CartItemCalibratable itemExpected) {
        CartItemCalibratable itemFound = null;
        for (CartItemCalibratable itemActual : itemsActual) {
            if (itemActual.equivalent(itemExpected)) {
                itemFound = itemActual;
                addChildCalibrator(CartItemCalibrator.getInstance(itemExpected, itemActual));
                break;
            }
        }
        return itemFound;
    }

    private void addCalibrationsUnexpected(List<CartItemCalibratable> itemsActual) {
        for (CartItemCalibratable itemActual : itemsActual) {
            addChildCalibrator(CartItemCalibrator.getInstance(null, itemActual));
        }
    }

    @Override
    protected void executeVerifications() {

    }
}
