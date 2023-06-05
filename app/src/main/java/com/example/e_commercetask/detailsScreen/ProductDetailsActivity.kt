package com.example.e_commercetask.detailsScreen

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.e_commercetask.R
import com.example.e_commercetask.app.showToast
import com.example.e_commercetask.databinding.ActivityProductDetailsBinding
import com.example.e_commercetask.databinding.ActivityProductsListBinding
import com.example.e_commercetask.productsList.data.models.ProductItemModel
import com.example.e_commercetask.productsList.presentation.ProductsListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailsBinding
    private val viewModel: ProductDetailsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listenToViewModelValues()
        getExtras()
        initViews()
    }

    private fun listenToViewModelValues() {
        viewModel.productsModel.observe(this) { product ->
            binding.apply {
                Glide.with(this@ProductDetailsActivity).load(product.image)
                    .into(productDetailsImage)
                productDetailsName.text = product.title
                productDetailsPrice.text = "${product.price} EGP"
                productDetailsDescription.text = product.description
            }
        }
    }

    private fun getExtras() {
        viewModel.setProductModel(intent.extras?.get(Product_Model) as ProductItemModel)
    }

    private fun initViews() {
        binding.apply {
            productDetailsBackButton.setOnClickListener {
                onBackPressedDispatcher.onBackPressed()
            }
            productDetailsAddToCart.setOnClickListener {
                viewModel.addItemToCart()
                showToast(getString(R.string.product_added_to_your_cart))
            }
        }
    }

    companion object {
        const val Product_Model = "Product_Model"

        fun getDetailsIntent(context: Context, productItemModel: ProductItemModel) {
            val intent = Intent(context, ProductDetailsActivity::class.java)
            val bundle = Bundle()
            bundle.putParcelable(Product_Model, productItemModel)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
    }
}