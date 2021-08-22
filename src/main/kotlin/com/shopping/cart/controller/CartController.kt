package com.shopping.cart.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cart")
class CartController {

    @GetMapping("/{cartId}")
    fun getProductsFromCart(@PathVariable("cartId") cartId: String): ResponseEntity<Any> {
        return ResponseEntity.status(200).build()
    }

    @PostMapping("/{cartId}/{productId}")
    fun addProduct(
        @PathVariable("cartId") cartId: String,
        @PathVariable("productId") productId: String
    ): ResponseEntity<Any> {
        return ResponseEntity.status(200).build()
    }

    @PutMapping("/{cartId}")
}