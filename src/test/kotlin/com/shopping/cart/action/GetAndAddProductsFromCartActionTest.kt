package com.shopping.cart.action

import com.shopping.cart.actions.cart.AddProductToCartAction
import com.shopping.cart.actions.cart.GetProductsFromCartAction
import com.shopping.cart.model.Cart
import com.shopping.cart.model.CartProduct
import com.shopping.cart.model.Product
import com.shopping.cart.provider.CartRepository
import com.shopping.cart.provider.ProductRepository
import org.junit.Before
import org.junit.Test

class GetAndAddProductsFromCartActionTest {

    lateinit var getProductsFromCartAction: GetProductsFromCartAction
    lateinit var addProductToCartAction: AddProductToCartAction

    val productRepository = ProductRepository()
    val cartRepository = CartRepository()

    @Before
    fun init() {
        getProductsFromCartAction = GetProductsFromCartAction(cartRepository, productRepository)
        addProductToCartAction = AddProductToCartAction(cartRepository)
    }

    @Test
    fun `given a cart with one product when get his products should return it`() {
        productRepository.addProduct(product)
        cartRepository.addCart(Cart())

        val productSaved = productRepository.getAllProducts().first()
        val cartSaved = cartRepository.getAllCarts().first()

        addProductToCartAction.addProductToCart(cartSaved.uuid!!, CartProduct(productSaved.uuid!!, 1))

        assert(getProductsFromCartAction.getProductsFromCart(cartSaved.uuid!!).size == 1)

    }

    companion object {
        val product =
            Product(sku = "sku", name = "name", description = "description", price = 20.0, hasDiscount = false)
    }
}