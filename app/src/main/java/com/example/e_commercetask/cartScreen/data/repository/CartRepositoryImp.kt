package com.example.e_commercetask.cartScreen.data.repository

import com.example.e_commercetask.cartScreen.data.data_source.LocalCartDataSource
import com.example.e_commercetask.cartScreen.domain.repository.CartRepository
import com.example.e_commercetask.productsList.data.models.ProductItemModel
import javax.inject.Inject

class CartRepositoryImp @Inject constructor(
    private val cartDataSource: LocalCartDataSource
) : CartRepository{
    override suspend fun getAllProducts() =
        cartDataSource.getAllProducts()

    override suspend fun deleteProduct(product: ProductItemModel) =
        cartDataSource.deleteProduct(product)

    override suspend fun deleteAllProducts() =
        cartDataSource.deleteAllProducts()

}