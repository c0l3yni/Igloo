package com.tekgs.nextgen.igloo.user.cart;

import jakarta.ws.rs.core.Response;

public class CartResponse implements CartResponseCalibratable {
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private final String responseJson;

    private CartResponse(Response response) {
        responseJson = response.readEntity(String.class);
    }

    public static CartResponse getInstance(Response response) {
        return new CartResponse(response);
    }
}
