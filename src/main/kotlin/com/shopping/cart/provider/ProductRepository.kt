package com.shopping.cart.provider

import com.shopping.cart.model.Product
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Service
import java.util.*

//TO DO: this class must be a repository (JPA for example)
@Service
@Scope("singleton")
class ProductRepository (private val allProducts: MutableList<Product> = mutableListOf()) {

    fun getAllProducts() = allProducts
    fun addProduct(product: Product) = allProducts.add(product.copy(uuid = UUID.randomUUID().toString()))
    fun removeProduct(product: Product) = allProducts.remove(product)
    fun modifyProduct(product: Product) = allProducts.find { productToReplace -> productToReplace.uuid == productToReplace.uuid }
    fun findByUUID(uuid: String) = allProducts.find { product -> product.uuid == uuid }
}