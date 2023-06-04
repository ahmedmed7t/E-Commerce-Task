package com.example.e_commercetask.productsList.domain.usecase

import com.example.e_commercetask.productsList.data.models.ProductItemModel
import javax.inject.Inject

class CategorizeProductListUseCase @Inject constructor() {
    operator fun invoke(productList: ArrayList<ProductItemModel>): ArrayList<ProductItemModel>{
        val sortedList = productList.groupBy { it.category }
            .flatMap { (category, products) ->
                arrayListOf(ProductItemModel(category = category,isHeader = true)) + products
            }

        return ArrayList(sortedList)
    }
}