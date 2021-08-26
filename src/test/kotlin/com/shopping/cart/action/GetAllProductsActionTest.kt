package com.shopping.cart.action

import com.shopping.cart.actions.product.GetAllProductsAction
import com.shopping.cart.model.Product
import com.shopping.cart.provider.ProductRepository
import org.junit.Before
import org.junit.Test

class GetAllProductsActionTest {

    lateinit var getAllProductsAction: GetAllProductsAction

    var repository = ProductRepository()

    @Before
    fun init() {
        getAllProductsAction = GetAllProductsAction(repository)
        repository.addProduct(firstProduct)
        repository.addProduct(secondProduct)
    }

    @Test
    fun `given a list of two products when get all products should return 2 elemnts`() {
        assert(getAllProductsAction.getAllProducts().size == 2)
    }

    companion object {
        val firstProduct =
            Product(sku = "sku", name = "name", description = "description", price = 20.0, hasDiscount = false)
        val secondProduct =
            Product(sku = "sku2", name = "name2", description = "description2", price = 20.0, hasDiscount = true)

    }
}