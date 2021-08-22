package com.shopping.cart.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("shopping/product")
class ProductController {

    @GetMapping
    fun getAllProducts(): ResponseEntity<Any> {
        return ResponseEntity.status(200).build()
    }

    @PostMapping
    fun addProduct(): ResponseEntity<Any> {
        return ResponseEntity.status(200).build()
    }

    @PutMapping
    fun modifyProduct(): ResponseEntity<Any> {
        return ResponseEntity.status(200).build()
    }

    @DeleteMapping("/{productId}")
    fun deleteProduct(@PathVariable("productId") productId: String): ResponseEntity<Any> {
        return ResponseEntity.status(200).build()
    }
}