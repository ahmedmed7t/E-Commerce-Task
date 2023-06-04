package com.example.e_commercetask.productsList.data.repository

import com.example.e_commercetask.productsList.data.data_source.ProductsListDataSource
import com.example.e_commercetask.productsList.data.local_data_source.LocalProductsListDataSource
import com.example.e_commercetask.productsList.data.models.ProductItemModel
import com.example.e_commercetask.productsList.domain.repository.ProductsListRepository
import javax.inject.Inject

class ProductsListRepositoryImp @Inject constructor(
    private val dataSource: ProductsListDataSource,
    private val localDataSource: LocalProductsListDataSource
) : ProductsListRepository {
    override suspend fun loadAllProducts() =
        dataSource.loadAllProducts()

    override suspend fun addProductToCart(product: ProductItemModel) =
        localDataSource.addProductToCart(product)

    override suspend fun updateProduct(product: ProductItemModel) =
        localDataSource.updateProduct(product)

    override suspend fun getProductById(productId: Int) =
        localDataSource.getProductById(productId)
}