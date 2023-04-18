package com.stripe.api.v1.charges;

public class ChargesResponseExpected implements ChargesResponseCalibratable {
    private final int amount;
    private static final int MAX = 99999999;
    private static final int MIN = 50;

    public ChargesResponseExpected(int amount) {
        this.amount = amount;
    }

    public static ChargesResponseExpected getInstance(int amount) {
        return new ChargesResponseExpected(amount);
    }

    @Override
    public boolean isPaymentSuccessful() {
        return amount >= MIN && amount <= MAX;
    }
}
