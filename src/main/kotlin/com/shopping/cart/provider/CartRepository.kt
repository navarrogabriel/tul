package com.shopping.cart.provider

import com.shopping.cart.model.Cart
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Service
import java.util.*

//TO DO: this class must be a repository (JPA for example)
@Service
@Scope("singleton")
class CartRepository(private val carts: MutableList<Cart> = mutableListOf()) {

    fun getAllCarts() = carts
    fun addCart(cart: Cart) = carts.add(cart.copy(uuid = UUID.randomUUID().toString()))
    fun removeCart(cart: Cart) = carts.remove(cart)
    fun findByUUID (uuid: String) = carts.find { it.uuid == uuid }
}
