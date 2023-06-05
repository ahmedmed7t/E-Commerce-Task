package com.example.e_commercetask.productsList.domain.usecase

import com.example.e_commercetask.productsList.domain.models.LoadProductsNetworkState
import com.example.e_commercetask.productsList.domain.repository.ProductsListRepository
import javax.inject.Inject

class LoadProductsUseCase @Inject constructor(
    private val productsListRepository: ProductsListRepository
) {
    suspend operator fun invoke() : LoadProductsNetworkState {
        productsListRepository.loadAllProducts().let { response ->
            return if (response.isSuccessful) {
                LoadProductsNetworkState.LoadSuccess(response.body() ?: arrayListOf())
            } else {
                LoadProductsNetworkState.LoadFail(response.message()?: "")
            }
        }
    }
}