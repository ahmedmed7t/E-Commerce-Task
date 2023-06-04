package com.example.e_commercetask.productsList.data.data_source

import com.example.e_commercetask.app.api.ApiService
import javax.inject.Inject

class ProductsListDataSourceImp @Inject constructor(private val apiService: ApiService): ProductsListDataSource {
    override suspend fun loadAllProducts() =
        apiService.getAllProducts()
}