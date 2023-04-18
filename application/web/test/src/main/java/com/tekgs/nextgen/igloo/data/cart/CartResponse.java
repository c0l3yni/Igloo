package com.tekgs.nextgen.igloo.data.cart;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

public class CartResponse {
    private final List<Cart> carts = new ArrayList<>();

    public CartResponse(Response response) {
        String responseJson = response.readEntity(String.class);
        carts.addAll(new Gson().fromJson(responseJson, new TypeToken<List<Cart>>() {
        }.getType()));
    }

    public static CartResponse getInstance(Response response) {
        return new CartResponse(response);
    }

    public List<Cart> getCarts() {
        return carts;
    }
}
