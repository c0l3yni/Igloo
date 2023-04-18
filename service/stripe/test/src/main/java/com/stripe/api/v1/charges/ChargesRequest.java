package com.stripe.api.v1.charges;

import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.Form;
import jakarta.ws.rs.core.Response;
import org.softwareonpurpose.softwaregauntlet.Environment;

public class ChargesRequest {
    private static final String STRIPE_SECRET_KEY = Environment.getInstance().getStripeSecretKey();
    private static final String source = "tok_visa";
    private static final String currency = "usd";
    private final int amount;
    private final Client client = ClientBuilder.newBuilder().build();
    private final String BASE_URL = Environment.getInstance().getBaseUrl();
    private final WebTarget target = client.target(String.format("%s/charges", BASE_URL));
    private final Invocation.Builder request = target.request();

    private ChargesRequest(int amount) {
        this.amount = amount;
    }

    public static ChargesRequest getInstance(int amount) {
        return new ChargesRequest(amount);
    }

    public Entity<Form> create() {
        Form chargeParams = new Form();
        chargeParams.param("amount", String.valueOf(this.amount));
        chargeParams.param("currency", currency);
        chargeParams.param("source", source);
        return Entity.form(chargeParams);
    }

    public ChargesResponse post() {
        request.header("Authorization", "Bearer " + STRIPE_SECRET_KEY);
        Response stripeResponse = request.post(this.create());
        ChargesResponse chargesResponse = ChargesResponse.getInstance(stripeResponse.readEntity(String.class));
        stripeResponse.close();
        return chargesResponse;
    }
}
