package com.shopping.cart.model

class DiscountProduct: ProductType {
    override fun getPrice(price: Double) = price/2
}