package com.shopping.cart.action

import com.shopping.cart.actions.cart.AddProductToCartAction
import com.shopping.cart.actions.cart.CheckoutCartAction
import com.shopping.cart.model.Cart
import com.shopping.cart.model.CartProduct
import com.shopping.cart.model.Product
import com.shopping.cart.provider.CartRepository
import com.shopping.cart.provider.ProductRepository
import org.junit.Before
import org.junit.Test

class CheckoutCartActionTest {

    lateinit var checkoutCartAction: CheckoutCartAction
    lateinit var addProductToCartAction: AddProductToCartAction

    val cartRepository = CartRepository()
    val productRepository = ProductRepository()

    @Before
    fun init() {
        checkoutCartAction = CheckoutCartAction(cartRepository, productRepository)
        addProductToCartAction = AddProductToCartAction(cartRepository)
    }

    @Test
    fun `given a cart with products when checkout it should return the correct price`() {

        productRepository.addProduct(product)
        productRepository.addProduct(discountProduct)
        cartRepository.addCart(Cart())

        val productSaved = productRepository.getAllProducts().first()
        val productDiscountSaved = productRepository.getAllProducts().last()
        val cartSaved = cartRepository.getAllCarts().first()

        addProductToCartAction.addProductToCart(cartSaved.uuid!!, CartProduct(productSaved.uuid!!, 1))
        addProductToCartAction.addProductToCart(cartSaved.uuid!!, CartProduct(productDiscountSaved.uuid!!, 2))

        assert(checkoutCartAction.checkoutCart(cartSaved.uuid!!) == 40.0)

    }

    companion object {
        val product =
            Product(sku = "sku", name = "name", description = "description", price = 20.0, hasDiscount = false)

        val discountProduct =
            Product(sku = "skuDiscount", name = "nameDiscount", description = "descriptionDiscount", price = 20.0, hasDiscount = true)
    }
}