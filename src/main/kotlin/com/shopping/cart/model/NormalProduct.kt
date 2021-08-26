package com.shopping.cart.model

class NormalProduct: ProductType {
    override fun getPrice(price: Double) = price
}