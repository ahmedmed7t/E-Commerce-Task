package com.example.e_commercetask.productsList.domain.repository

import com.example.e_commercetask.productsList.data.models.ProductItemModel
import retrofit2.Response

interface ProductsListRepository {
    suspend fun loadAllProducts(): Response<ArrayList<ProductItemModel>>

    suspend fun addProductToCart(product: ProductItemModel)

    suspend fun updateProduct(product: ProductItemModel)

    suspend fun getProductById(productId: Int): ProductItemModel?
}