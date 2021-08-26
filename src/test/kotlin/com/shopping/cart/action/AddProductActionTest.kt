package com.shopping.cart.action

import com.shopping.cart.actions.product.AddProductAction
import com.shopping.cart.model.Product
import com.shopping.cart.provider.ProductRepository
import org.junit.Before
import org.junit.Test

class AddProductActionTest {

    lateinit var addProductAction: AddProductAction

    val productRepository = ProductRepository()

    @Before
    fun init() {
        addProductAction = AddProductAction(productRepository)
    }

    @Test
    fun `given a add product when get all products should return it`() {
        addProductAction.addProduct(product)
        assert(productRepository.getAllProducts().size == 1)
    }

    companion object {
        val product =
            Product(sku = "sku", name = "name", description = "description", price = 20.0, hasDiscount = false)
    }
}