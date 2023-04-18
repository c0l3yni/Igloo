package com.stripe.api.v1.charges;

import com.google.gson.Gson;

@SuppressWarnings("unused")
public class ChargesResponse implements ChargesResponseCalibratable {
    private String status;
    private boolean paid;

    private ChargesResponse() {
    }

    public static ChargesResponse getInstance(String responseJson) {
        return new Gson().fromJson(responseJson, ChargesResponse.class);
    }

    @Override
    public boolean isPaymentSuccessful() {
        return "succeeded".equals(status) && paid;
    }
}
