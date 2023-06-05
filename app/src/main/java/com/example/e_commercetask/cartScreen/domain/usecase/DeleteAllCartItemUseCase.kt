package com.example.e_commercetask.cartScreen.domain.usecase

import com.example.e_commercetask.cartScreen.domain.repository.CartRepository
import com.example.e_commercetask.productsList.data.models.ProductItemModel
import javax.inject.Inject

class DeleteAllCartItemUseCase @Inject constructor(private val cartRepository: CartRepository) {
    suspend operator fun invoke() {
       cartRepository.deleteAllProducts()
    }
}