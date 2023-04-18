import React, { useEffect, useState } from "react";
import { Link, useSearchParams } from "react-router-dom";
import "./cart.css";
import ItemsRegion from "./ItemsRegion";

export default function Cart() {
  const [searchParams] = useSearchParams();
  const id = searchParams.get("id");
  const [items, setItems] = useState([]);

  useEffect(() => {
    if (!id) {
      return;
    }
    fetch(`${process.env.REACT_APP_USER_SERVICE_URI}cart/${id}`)
      .then((res) => res.json())
      .then((data) => setItems(data.items));
  }, [id]);

  function getCartTotal() {
    return items
      .map((item) => item.quantity * item.product.price)
      .reduce((prev, current) => prev + current, 0);
  }

  function formatCurrency(amount) {
    return `$${(amount / 100).toFixed(2)}`;
  }

  function getButtonClass() {
    if (getCartTotal() === 0) {
      return "button-disabled";
    }
    return "button-enabled";
  }

  function increment(product, value) {
    const itemIndex = items.findIndex((item) => item.product.id === product.id);
    const newItems = [...items];
    newItems[itemIndex] = {
      ...newItems[itemIndex],
      quantity: newItems[itemIndex].quantity + value,
    };
    setItems(newItems);
    console.log(newItems);
    fetch(`${process.env.REACT_APP_USER_SERVICE_URI}cart/${id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ items: newItems }),
    });
  }

  return (
    <div id="cart-view">
      <ItemsRegion items={items} increment={increment} />
      <div className="subtotal-container">
        <h3>Subtotal:</h3>
        <h4 id="cart-total">{formatCurrency(getCartTotal())}</h4>
        <Link
          to={
            getButtonClass() === "button-enabled"
              ? `/payment-submission?amount=${getCartTotal()}`
              : null
          }
        >
          <button
            className={`${getButtonClass()} igloo-button`}
            id="submit-payment"
          >
            Submit Payment
          </button>
        </Link>
      </div>
    </div>
  );
}
