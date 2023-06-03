package com.example.e_commercetask.productsList.domain.usecase

import com.example.e_commercetask.productsList.domain.repository.ProductsListRepository
import javax.inject.Inject

class LoadProductsUseCase @Inject constructor(
    private val productsListRepository: ProductsListRepository
) {
}