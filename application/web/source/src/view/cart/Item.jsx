import React from "react";
import "./cart.css";

export default function Item({ item, increment }) {
  const { product, quantity } = item;

  return (
    <div className="item">
      <div className="product" data-id={product.id}>
        <p className="product-description">{product.description}</p>
        <p className="product-price">${(product.price / 100).toFixed(2)}</p>
      </div>
      <div className="product-quantity-group">
        <button
          className="decrement igloo-button"
          onClick={() => increment(product, -1)}
        >
          -
        </button>
        <p className="item-quantity">{quantity}</p>
        <button
          className="increment igloo-button"
          onClick={() => increment(product, 1)}
        >
          +
        </button>
      </div>
    </div>
  );
}
