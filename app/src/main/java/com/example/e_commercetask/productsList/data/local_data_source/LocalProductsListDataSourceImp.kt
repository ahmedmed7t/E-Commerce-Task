package com.example.e_commercetask.productsList.data.local_data_source

import com.example.e_commercetask.app.room.ProductsDao
import com.example.e_commercetask.app.room.ProductsDataBase
import com.example.e_commercetask.productsList.data.models.ProductItemModel
import javax.inject.Inject

class LocalProductsListDataSourceImp @Inject constructor(
    private val productsDataBase: ProductsDao
): LocalProductsListDataSource {
    override suspend fun addProductToCart(product: ProductItemModel) =
        productsDataBase.insert(product)

    override suspend fun updateProduct(product: ProductItemModel) =
        productsDataBase.update(product)

    override suspend fun getProductById(productId: Int) =
        productsDataBase.getProductById(productId)


}