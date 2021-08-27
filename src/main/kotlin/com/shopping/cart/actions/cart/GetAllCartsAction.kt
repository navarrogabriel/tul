package com.shopping.cart.actions.cart

import com.shopping.cart.provider.CartRepository
import org.springframework.stereotype.Service

@Service
class GetAllCartsAction (private val cartRepository: CartRepository) {

    fun getAllCarts() = cartRepository.getAllCarts()
}