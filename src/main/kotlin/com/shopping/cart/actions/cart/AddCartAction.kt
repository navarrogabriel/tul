package com.shopping.cart.actions.cart

import com.shopping.cart.model.Cart
import com.shopping.cart.provider.CartRepository
import org.springframework.stereotype.Service

@Service
class AddCartAction(private val cartRepository: CartRepository) {

    fun addCart(cart: Cart) = cartRepository.addCart(cart)
}