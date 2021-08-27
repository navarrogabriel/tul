package com.shopping.cart.controller

import com.shopping.cart.actions.cart.*
import com.shopping.cart.model.Cart
import com.shopping.cart.model.CartProduct
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("shopping/cart")
class CartController(
    private val addCartAction: AddCartAction,
    private val getAllCartsAction: GetAllCartsAction,
    private val addProductToCartAction: AddProductToCartAction,
    private val getProductsFromCartAction: GetProductsFromCartAction,
    private val checkoutCartAction: CheckoutCartAction
) {

    @GetMapping("/{cartId}")
    fun getProductsFromCart(@PathVariable("cartId") cartId: String): ResponseEntity<Any> {
        return ResponseEntity.ok(getProductsFromCartAction.getProductsFromCart(cartId))
    }

    @GetMapping
    fun getAllCarts(): ResponseEntity<Any> {
        return ResponseEntity.ok(getAllCartsAction.getAllCarts())
    }

    @GetMapping("/checkout/{cartId}")
    fun checkoutCart(@PathVariable("cartId") cartId: String): ResponseEntity<Any> {
        return ResponseEntity.ok(checkoutCartAction.checkoutCart(cartId))
    }

    @PostMapping
    fun createCart(@RequestBody newCart: Cart): ResponseEntity<Any> {
        return ResponseEntity.ok(addCartAction.addCart(newCart))
    }

    @PostMapping("/add/{cartId}")
    fun addProduct(
        @PathVariable("cartId") cartId: String,
        @RequestBody newProduct: CartProduct
    ): ResponseEntity<Any> {
        return ResponseEntity.ok(addProductToCartAction.addProductToCart(cartId, newProduct))
    }

}