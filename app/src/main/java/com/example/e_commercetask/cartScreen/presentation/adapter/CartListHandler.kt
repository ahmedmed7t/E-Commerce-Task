package com.example.e_commercetask.cartScreen.presentation.adapter

import com.example.e_commercetask.productsList.data.models.ProductItemModel

interface CartListHandler {
    fun onProductDeleteClicked(product: ProductItemModel)
}