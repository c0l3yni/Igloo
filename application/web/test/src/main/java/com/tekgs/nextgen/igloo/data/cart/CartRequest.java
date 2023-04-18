package com.tekgs.nextgen.igloo.data.cart;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import org.softwareonpurpose.softwaregauntlet.Environment;

public class CartRequest {
    private static final String DOMAIN_URL= Environment.getInstance().getUserUrl();
    private static final String RELATIVE_URL = "cart";
    private static final String SERVICE_URL = String.format("%s/%s",DOMAIN_URL,RELATIVE_URL);

    public static CartRequest getInstance() {
        return new CartRequest();
    }

    public CartResponse get() {
        CartResponse cartResponse;
        try (Client build = ClientBuilder.newBuilder().build()) {
            System.out.printf("Send request to %s...%n", SERVICE_URL);
            cartResponse = CartResponse.getInstance(build.target(SERVICE_URL).request().get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return cartResponse;
    }
}
