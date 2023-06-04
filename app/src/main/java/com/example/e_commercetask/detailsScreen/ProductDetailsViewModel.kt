package com.example.e_commercetask.detailsScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.e_commercetask.productsList.data.models.ProductItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(): ViewModel() {
    private val _productsModel = MutableLiveData<ProductItemModel>()
    val productsModel: LiveData<ProductItemModel> get() = _productsModel

    fun setProductModel(product: ProductItemModel?){
        _productsModel.value = product
    }
}