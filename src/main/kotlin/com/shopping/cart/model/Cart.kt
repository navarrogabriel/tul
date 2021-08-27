package com.shopping.cart.model

data class Cart(
    val uuid: String? = null,
    var products: MutableList<CartProduct> = mutableListOf(),
    var cartStatus: CartStatus = CartStatus.PENDING
)

enum class CartStatus {
    PENDING, COMPLETED
}