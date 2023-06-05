package com.example.e_commercetask.productsList.data.local_data_source

import com.example.e_commercetask.productsList.data.models.ProductItemModel

interface LocalProductsListDataSource {
    suspend fun addProductToCart(product: ProductItemModel)

    suspend fun updateProduct(product: ProductItemModel)

    suspend fun getProductById(productId: Int): ProductItemModel?
}