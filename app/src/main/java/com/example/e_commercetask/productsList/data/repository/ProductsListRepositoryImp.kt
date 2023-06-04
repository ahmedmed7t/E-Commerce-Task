package com.example.e_commercetask.productsList.data.repository

import com.example.e_commercetask.productsList.data.data_source.ProductsListDataSource
import com.example.e_commercetask.productsList.domain.repository.ProductsListRepository
import javax.inject.Inject

class ProductsListRepositoryImp @Inject constructor(private val dataSource: ProductsListDataSource): ProductsListRepository {
    override suspend fun loadAllProducts() =
        dataSource.loadAllProducts()
}