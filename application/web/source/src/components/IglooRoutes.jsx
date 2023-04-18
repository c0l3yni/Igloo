import React from 'react'
import { Routes, Route} from 'react-router-dom'
import Cart from '../view/cart/Cart'
import CatchAllError from '../view/catch-all-error/CatchAllError'
import InvalidUrlError from '../view/invalid-url-error/InvalidUrlError'
import PaymentConfirmation from '../view/payment-confirmation/PaymentConfirmation'
import PaymentSubmission from '../view/payment-submission/PaymentSubmission'

export default function IglooRoutes() {
  return (
    <Routes>
        <Route path='/cart' element={<Cart />}/>
        <Route path='/catch-all-error' element={<CatchAllError />}/>     
        <Route path='/payment-confirmation' element={<PaymentConfirmation />}/>     
        <Route path='/payment-submission' element={<PaymentSubmission />}/>     
        <Route path='*' element={<InvalidUrlError />}/>     
    </Routes>
  )
}
