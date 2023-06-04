package com.example.e_commercetask.productsList.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commercetask.loginScreen.presentation.models.LoginUiState
import com.example.e_commercetask.productsList.data.models.ProductItemModel
import com.example.e_commercetask.productsList.domain.models.LoadProductsNetworkState
import com.example.e_commercetask.productsList.domain.usecase.AddProductToCartUseCase
import com.example.e_commercetask.productsList.domain.usecase.CategorizeProductListUseCase
import com.example.e_commercetask.productsList.domain.usecase.FilterProductListUseCase
import com.example.e_commercetask.productsList.domain.usecase.LoadProductsUseCase
import com.example.e_commercetask.productsList.presentation.models.ProductsUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsListViewModel @Inject constructor(
    private val loadProductsUseCase: LoadProductsUseCase,
    private val categorizeProductListUseCase: CategorizeProductListUseCase,
    private val filterProductListUseCase: FilterProductListUseCase,
    private val addProductToCartUseCase: AddProductToCartUseCase
) : ViewModel() {

    private val _loadProductsState = MutableLiveData<ProductsUIState>()
    val loadProductsState: LiveData<ProductsUIState> get() = _loadProductsState

    fun loadAllProducts() {
        viewModelScope.launch {
            loadProductsUseCase.invoke().let {
                when (it) {
                    is LoadProductsNetworkState.LoadFail ->
                        _loadProductsState.value = ProductsUIState.Fail(it.errorMessage)

                    is LoadProductsNetworkState.LoadSuccess -> {
                        _loadProductsState.value = ProductsUIState.Success(
                            products = categorizeProductListUseCase(it.products)
                        )
                    }
                }
            }
        }
    }

    fun filterList(keyword: String): ArrayList<ProductItemModel> {
        return if (_loadProductsState.value is ProductsUIState.Success) {
            filterProductListUseCase(
                (_loadProductsState.value as ProductsUIState.Success).products,
                keyword
            )
        } else {
            arrayListOf()
        }
    }

    fun addItemToCart(productItemModel: ProductItemModel) {
        viewModelScope.launch {
            addProductToCartUseCase(productItemModel)
        }
    }
}