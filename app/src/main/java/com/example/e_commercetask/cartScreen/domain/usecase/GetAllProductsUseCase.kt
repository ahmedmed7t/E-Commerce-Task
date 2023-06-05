package com.example.e_commercetask.cartScreen.domain.usecase

import com.example.e_commercetask.cartScreen.domain.model.CartModel
import com.example.e_commercetask.cartScreen.domain.repository.CartRepository
import com.example.e_commercetask.productsList.data.models.ProductItemModel
import javax.inject.Inject

class GetAllProductsUseCase @Inject constructor(private val cartRepository: CartRepository) {
    suspend operator fun invoke(): CartModel {
        val cartItems = cartRepository.getAllProducts()
        return CartModel(cartItems, getTotalAmount(cartItems))
    }

    private fun getTotalAmount(cartItems: List<ProductItemModel>): Double {
        var totalAmount = 0.0
        for (item in cartItems){
            totalAmount += (item.price * item.quantity)
        }

        return totalAmount
    }
}