package com.example.e_commercetask.cartScreen.data.data_source

import com.example.e_commercetask.productsList.data.models.ProductItemModel

interface LocalCartDataSource {

    suspend fun getAllProducts(): List<ProductItemModel>

    suspend fun deleteProduct(product: ProductItemModel)

    suspend fun deleteAllProducts()
}