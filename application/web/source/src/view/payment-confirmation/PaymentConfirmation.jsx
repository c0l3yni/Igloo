import React from 'react'
import {useSearchParams} from 'react-router-dom'
import './payment-confirmation.css'

export default function PaymentConfirmation() {
    const [searchParams] = useSearchParams()
    const paymentStatus = searchParams.get('status')

    function isPaymentSuccessful(paymentStatus) {
        return "succeeded" === paymentStatus.toLowerCase();
    }

    function paymentSuccessfulMessage(paymentStatus) {
        return isPaymentSuccessful(paymentStatus) ? "Payment Successful :)" : "";
    }

    return (
        <div id="payment-confirmation-view">
            <h1 id="confirmation-message">{paymentSuccessfulMessage(paymentStatus)}</h1>
        </div>
    )
}
