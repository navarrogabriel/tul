package com.shopping.cart.controller

import com.shopping.cart.actions.product.AddProductAction
import com.shopping.cart.actions.product.GetAllProductsAction
import com.shopping.cart.actions.product.ModifyProductAction
import com.shopping.cart.actions.product.RemoveProductAction
import com.shopping.cart.model.Product
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("shopping/product")
class ProductController(
    private val getAllProductsAction: GetAllProductsAction,
    private val addProductAction: AddProductAction,
    private val removeProductAction: RemoveProductAction,
    private val modifyProductAction: ModifyProductAction
) {

    @GetMapping
    fun getAllProducts(): ResponseEntity<Any> {
        return ResponseEntity.ok(getAllProductsAction.getAllProducts())
    }

    @PostMapping
    fun addProduct(@RequestBody newProduct: Product): ResponseEntity<Any> {
        return ResponseEntity.ok(addProductAction.addProduct(newProduct))
    }

    @PutMapping
    fun modifyProduct(@RequestBody newProduct: Product): ResponseEntity<Any> {
        return ResponseEntity.ok(modifyProductAction.modifyProduct(newProduct))
    }

    @DeleteMapping("/{productId}")
    fun deleteProduct(@PathVariable("productId") productId: String): ResponseEntity<Any> {
        return ResponseEntity.ok(removeProductAction.removeProduct(productId))
    }
}