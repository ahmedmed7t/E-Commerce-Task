package com.example.e_commercetask.cartScreen.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_commercetask.databinding.CartItemViewBinding
import com.example.e_commercetask.productsList.data.models.ProductItemModel

class CartRecyclerAdapter(
    private var productList: List<ProductItemModel>,
    private val productHandler: CartListHandler
) : RecyclerView.Adapter<CartRecyclerAdapter.ProductViewHolder>() {


    inner class ProductViewHolder(val binding: CartItemViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ProductViewHolder(
            CartItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(
        holder: CartRecyclerAdapter.ProductViewHolder,
        position: Int
    ) {
        holder.binding.apply {
            cartItemTitle.text = productList[position].title
            cartItemPrice.text = "${productList[position].price} EGP"
            cartItemQuantity.text = "${productList[position].quantity}"
            Glide.with(root.context).load(productList[position].image).into(cartItemImage)
            cartItemDelete.setOnClickListener {
                productHandler.onProductDeleteClicked(productList[position])
            }
        }
    }

    fun addProducts(products: List<ProductItemModel>) {
        productList = products
        notifyDataSetChanged()
    }

    override fun getItemCount() =
        productList.size
}