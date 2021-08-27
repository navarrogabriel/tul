package com.shopping.cart.actions.cart

import com.shopping.cart.model.Product
import com.shopping.cart.provider.CartRepository
import com.shopping.cart.provider.ProductRepository
import org.springframework.stereotype.Service
import java.lang.Exception
import java.lang.RuntimeException

@Service
class GetProductsFromCartAction(
    private val cartRepository: CartRepository,
    private val productRepository: ProductRepository
) {

    fun getProductsFromCart(cartId: String): List<Product> {
        return try {
            cartRepository.findByUUID(cartId)?.let { cart ->
                cart.products.map { product ->
                    productRepository.findByUUID(product.productId)!!
                }
            }?.toList().orEmpty()
        } catch (e: Exception) {
            throw ProductNotFoundException()
        }
    }
}

class ProductNotFoundException : RuntimeException()