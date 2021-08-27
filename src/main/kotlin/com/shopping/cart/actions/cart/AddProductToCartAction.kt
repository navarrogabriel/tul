package com.shopping.cart.actions.cart

import com.shopping.cart.model.CartProduct
import com.shopping.cart.provider.CartRepository
import org.springframework.stereotype.Service

@Service
class AddProductToCartAction(
    private val cartRepository: CartRepository
) {

    fun addProductToCart(cartUuid: String, cartProduct: CartProduct) {
        cartRepository.findByUUID(cartUuid)?.products?.add(cartProduct)
    }
}