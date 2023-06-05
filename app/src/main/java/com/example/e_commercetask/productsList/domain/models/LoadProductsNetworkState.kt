package com.example.e_commercetask.productsList.domain.models

import com.example.e_commercetask.productsList.data.models.ProductItemModel

sealed class LoadProductsNetworkState {
    data class LoadFail(val errorMessage: String): LoadProductsNetworkState()
    data class LoadSuccess(val products: ArrayList<ProductItemModel>): LoadProductsNetworkState()
}