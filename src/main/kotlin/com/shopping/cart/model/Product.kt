package com.shopping.cart.model

data class Product(
    val uuid: String? = null,
    val sku: String,
    val name: String,
    val description: String,
    val price: Double,
    val hasDiscount: Boolean,
    var productType: ProductType? = null
) {
    init {
        productType = if (hasDiscount) DiscountProduct() else NormalProduct()
    }
}