package com.example.e_commercetask.loginScreen.domain.usecase

import com.example.e_commercetask.productsList.domain.repository.ProductsListRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val productsListRepository: ProductsListRepository
) {
}