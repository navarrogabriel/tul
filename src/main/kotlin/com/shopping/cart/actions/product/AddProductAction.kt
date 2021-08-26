package com.shopping.cart.actions.product

import com.shopping.cart.model.Product
import com.shopping.cart.provider.ProductRepository
import org.springframework.stereotype.Service

@Service
class AddProductAction (private val productRepository: ProductRepository) {

    fun addProduct(product: Product) = productRepository.addProduct(product)
}