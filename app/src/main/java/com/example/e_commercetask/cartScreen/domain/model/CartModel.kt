package com.example.e_commercetask.cartScreen.domain.model

import com.example.e_commercetask.productsList.data.models.ProductItemModel

data class CartModel(
    val cartItems: List<ProductItemModel>,
    val totalAmount: Double
)