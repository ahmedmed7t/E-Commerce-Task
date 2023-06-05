package com.example.e_commercetask.detailsScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commercetask.productsList.data.models.ProductItemModel
import com.example.e_commercetask.productsList.domain.usecase.AddProductToCartUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    private val addProductToCartUseCase: AddProductToCartUseCase
): ViewModel() {
    private val _productsModel = MutableLiveData<ProductItemModel>()
    val productsModel: LiveData<ProductItemModel> get() = _productsModel

    fun setProductModel(product: ProductItemModel?){
        _productsModel.value = product
    }

    fun addItemToCart() {
        viewModelScope.launch {
            _productsModel.value?.let { addProductToCartUseCase(it) }
        }
    }
}