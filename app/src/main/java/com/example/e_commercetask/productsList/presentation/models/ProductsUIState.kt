package com.example.e_commercetask.productsList.presentation.models

import com.example.e_commercetask.productsList.data.models.ProductItemModel

sealed class ProductsUIState{
    data class Success(val products: ArrayList<ProductItemModel>): ProductsUIState()
    data class Fail(val errorMessage: String): ProductsUIState()
}
