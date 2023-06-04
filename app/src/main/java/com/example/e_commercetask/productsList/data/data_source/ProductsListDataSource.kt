package com.example.e_commercetask.productsList.data.data_source

import com.example.e_commercetask.productsList.data.models.ProductItemModel
import retrofit2.Response

interface ProductsListDataSource {
    suspend fun loadAllProducts(): Response<ArrayList<ProductItemModel>>
}