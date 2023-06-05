package com.example.e_commercetask.cartScreen.domain.repository

import com.example.e_commercetask.productsList.data.models.ProductItemModel
import retrofit2.Response

interface CartRepository {
    suspend fun getAllProducts(): List<ProductItemModel>

    suspend fun deleteProduct(product: ProductItemModel)

    suspend fun deleteAllProducts()
}