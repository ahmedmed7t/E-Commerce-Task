package com.example.e_commercetask.productsList.domain.usecase

import com.example.e_commercetask.productsList.data.models.ProductItemModel
import com.example.e_commercetask.productsList.domain.models.LoadProductsNetworkState
import com.example.e_commercetask.productsList.domain.repository.ProductsListRepository
import javax.inject.Inject

class AddProductToCartUseCase @Inject constructor(
    private val productsListRepository: ProductsListRepository
) {
    suspend operator fun invoke(product: ProductItemModel)  {
        val oldProduct = productsListRepository.getProductById(productId = product.id)
        if (oldProduct == null) {
            productsListRepository.addProductToCart(product.copy(quantity = 1))
        } else {
            productsListRepository.updateProduct(
                oldProduct.copy(quantity = oldProduct.quantity + 1)
            )
        }
    }
}