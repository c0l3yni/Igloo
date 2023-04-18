import React from "react";
import "./payment-submission.css";
import { useSearchParams } from "react-router-dom";

export default function PaymentSubmission() {
  const [searchParams] = useSearchParams();
  const amount = searchParams.get("amount");

  return (
    <div id="payment-view-submission">
      <div class="payment-submission-container">
        <div class="payment-submission-subcontainer">
          <div class="total-container">
            <h1>Total:</h1>
            <h1 id="payment-total">${(amount / 100).toFixed(2)}</h1>
          </div>
          <form id="payment-form">
            <div>
              <input type="radio" name="currency" id="usd" value="USD" />
              <label for="usd">USD</label>
              <br />
              <input type="radio" name="currency" id="eur" value="EUR" />
              <label for="eur">EUR</label>
            </div>
            <label for="source">Source: </label>
            <input type="text" name="source" id="source" />
          </form>
        </div>
      </div>
    </div>
  );
}
