package com.shopping.cart.action

import com.shopping.cart.actions.product.RemoveProductAction
import com.shopping.cart.model.Product
import com.shopping.cart.provider.ProductRepository
import org.junit.Before
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

class RemoveProductActionTest {

    var repository = ProductRepository()

    @Autowired
    lateinit var removeProductAction: RemoveProductAction

    @Before
    fun init() {
        removeProductAction = RemoveProductAction(repository)
        repository.addProduct(product)
    }

    @Test
    fun `given a product int repository when delete it should remove`() {
        val allProducts = repository.getAllProducts()
        assert(allProducts.isNotEmpty())
        removeProductAction.removeProduct(allProducts.first().uuid!!)

        assert(repository.getAllProducts().isEmpty())
    }

    companion object {
        val product =
            Product(sku = "sku", name = "name", description = "description", price = 20.0, hasDiscount = false)
    }
}