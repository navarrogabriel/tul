package com.shopping.cart.actions.product

import com.shopping.cart.model.Product
import com.shopping.cart.provider.ProductRepository
import org.springframework.stereotype.Service

@Service
class ModifyProductAction (private val productRepository: ProductRepository){

    fun modifyProduct(product: Product) {
        val allProducts = productRepository.getAllProducts()
        allProducts.find { productToReplace -> productToReplace.uuid == product.uuid }.let {

        }
    }
}