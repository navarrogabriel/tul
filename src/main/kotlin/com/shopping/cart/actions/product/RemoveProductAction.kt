package com.shopping.cart.actions.product

import com.shopping.cart.model.Product
import com.shopping.cart.provider.ProductRepository
import org.springframework.stereotype.Service

@Service
class RemoveProductAction(private val productRepository: ProductRepository) {

    fun removeProduct(productId: String) {
       productRepository.findByUUID(productId)?.let { productRepository.removeProduct(it) }
    }
}