package com.example.e_commercetask.productsList.presentation.adapter

import com.example.e_commercetask.productsList.data.models.ProductItemModel

interface ProductListHandler {
    fun onProductClicked(product: ProductItemModel)
    fun onAddProductToCart(product: ProductItemModel)
}