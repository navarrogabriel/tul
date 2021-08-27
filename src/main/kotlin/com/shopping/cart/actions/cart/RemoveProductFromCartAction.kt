package com.shopping.cart.actions.cart

import com.shopping.cart.provider.CartRepository
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class RemoveProductFromCartAction(private val cartRepository: CartRepository) {

    val logger = Logger.getLogger("RemoveProductFromCartAction")

    fun removeProductFromCart(cartId: String, productId: String) {
        logger.info("Deleting product $productId from $cartId")
        cartRepository.findByUUID(cartId)?.let { cart ->
            val afterDelete = cart.products.filter { it.productId == productId }.toMutableList()
            cart.products = afterDelete
            logger.info("Delete complete")
        }
    }
}