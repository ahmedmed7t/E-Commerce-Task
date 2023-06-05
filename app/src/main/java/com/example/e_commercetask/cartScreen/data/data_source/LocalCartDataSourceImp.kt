package com.example.e_commercetask.cartScreen.data.data_source

import com.example.e_commercetask.app.room.ProductsDao
import com.example.e_commercetask.productsList.data.models.ProductItemModel
import javax.inject.Inject

class LocalCartDataSourceImp @Inject constructor(
    private val productsDataBase: ProductsDao
) : LocalCartDataSource {
    override suspend fun getAllProducts() =
        productsDataBase.getAllProducts()

    override suspend fun deleteProduct(product: ProductItemModel) =
        productsDataBase.deleteProduct(product)

    override suspend fun deleteAllProducts() =
        productsDataBase.deleteAllProducts()
}