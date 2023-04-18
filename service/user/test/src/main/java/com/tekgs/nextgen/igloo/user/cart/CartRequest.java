package com.tekgs.nextgen.igloo.user.cart;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import org.softwareonpurpose.softwaregauntlet.Environment;

public class CartRequest {
    private static final String USER_URL = Environment.getInstance().getUserUrl();
    private static final String RELATIVE_URL = "cart";
    private static final String URI = String.format("%s/%s", USER_URL, RELATIVE_URL);

    private CartRequest() {
    }

    public static CartRequest getInstance() {
        return new CartRequest();
    }

    public CartResponse get() {
        CartResponse response;
        try (Client client = ClientBuilder.newBuilder().build()) {
            WebTarget target = client.target(URI);
            response = CartResponse.getInstance(target.request().get());
        }
        return response;
    }
}
