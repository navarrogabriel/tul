package com.shopping.cart.actions.product

import com.shopping.cart.model.Product
import com.shopping.cart.provider.ProductRepository
import org.springframework.stereotype.Service

@Service
class GetAllProductsAction(private val productRepository: ProductRepository) {

    fun getAllProducts(): List<Product> = productRepository.getAllProducts()
}