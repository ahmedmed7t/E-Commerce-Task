package com.example.e_commercetask.cartScreen.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commercetask.cartScreen.domain.model.CartModel
import com.example.e_commercetask.cartScreen.domain.usecase.DeleteAllCartItemUseCase
import com.example.e_commercetask.cartScreen.domain.usecase.DeleteCartItemUseCase
import com.example.e_commercetask.cartScreen.domain.usecase.GetAllProductsUseCase
import com.example.e_commercetask.productsList.data.models.ProductItemModel
import com.example.e_commercetask.productsList.presentation.models.ProductsUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val getAllProductsUseCase: GetAllProductsUseCase,
    private val deleteCartItemUseCase: DeleteCartItemUseCase,
    private val deleteAllCartItemUseCase: DeleteAllCartItemUseCase
) : ViewModel() {
    private val _cartModelState = MutableLiveData<CartModel>()
    val cartModelState: LiveData<CartModel> get() = _cartModelState

    fun loadCart() {
        viewModelScope.launch {
            _cartModelState.value = getAllProductsUseCase()
        }
    }

    fun deleteCartItem(productItemModel: ProductItemModel) {
        viewModelScope.launch {
            deleteCartItemUseCase(productItemModel)
            _cartModelState.value = getAllProductsUseCase()
        }
    }

    fun emptyCart(){
        viewModelScope.launch {
            deleteAllCartItemUseCase()
            _cartModelState.value = CartModel(arrayListOf(), 0.0)
        }
    }
}