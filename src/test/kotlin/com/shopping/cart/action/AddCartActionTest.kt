package com.shopping.cart.action

import com.shopping.cart.actions.cart.AddCartAction
import com.shopping.cart.model.Cart
import com.shopping.cart.provider.CartRepository
import org.junit.Before
import org.junit.Test

class AddCartActionTest {

    lateinit var addCartAction: AddCartAction

    val cartRepository = CartRepository()

    @Before
    fun init(){
        addCartAction = AddCartAction(cartRepository)
    }

    @Test
    fun `given a add cart to repository when get all carts should return 1`() {
        addCartAction.addCart(cart)
        assert(cartRepository.getAllCarts().size == 1)
    }

    companion object {
        val cart = Cart()
    }
}