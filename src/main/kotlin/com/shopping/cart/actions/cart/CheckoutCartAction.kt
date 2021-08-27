package com.shopping.cart.actions.cart

import com.shopping.cart.model.CartStatus
import com.shopping.cart.provider.CartRepository
import com.shopping.cart.provider.ProductRepository
import org.springframework.stereotype.Service

@Service
class CheckoutCartAction(
    private val cartRepository: CartRepository,
    private val productRepository: ProductRepository
) {

    fun checkoutCart(cartId: String): Double {
        var totalAmount = 0.0
        cartRepository.findByUUID(cartId)?.let { cart ->
            cart.products.forEach { cartProduct ->
                productRepository.findByUUID(cartProduct.productId)?.let { product ->
                    totalAmount += product.productType!!.getPrice(product.price) * cartProduct.productQtty
                }
            }

            cart.cartStatus = CartStatus.COMPLETED
        }

        return totalAmount
    }
}