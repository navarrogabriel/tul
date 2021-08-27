package com.shopping.cart.actions.cart

import com.shopping.cart.model.CartProduct
import com.shopping.cart.provider.CartRepository
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class AddProductToCartAction(
    private val cartRepository: CartRepository
) {

    val logger = Logger.getLogger("AddProductToCartAction")

    fun addProductToCart(cartUuid: String, cartProduct: CartProduct) {
        logger.info("Adding product ${cartProduct.productId} to $cartUuid")
        cartRepository.findByUUID(cartUuid)?.products?.add(cartProduct)
    }
}