package com.example.e_commercetask.productsList.domain.usecase

import com.example.e_commercetask.productsList.data.models.ProductItemModel
import javax.inject.Inject

class FilterProductListUseCase @Inject constructor() {
    operator fun invoke(
        productList: ArrayList<ProductItemModel>,
        keyword: String
    ): ArrayList<ProductItemModel> {
        val sortedList = productList.filter { it.title.contains(keyword, ignoreCase = true) }
        return ArrayList(sortedList)
    }
}