package com.tekgs.nextgen.igloo.data.cart;

public class CartProvider {
    private final CartRepository repository = CartRepository.getInstance();

    public static CartProvider getInstance() {
        return new CartProvider();
    }

    public Cart get(CartCalibratable definition) {
        return repository.query(definition);
    }

    public Cart get() {
        return get(CartDefinition.getInstance());
    }
}
