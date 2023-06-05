package com.example.e_commercetask.productsList.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_commercetask.databinding.ProductHeaderItemViewBinding
import com.example.e_commercetask.databinding.ProductItemViewBinding
import com.example.e_commercetask.productsList.data.models.ProductItemModel

private val HEADER_ITEM = 0
private val PRODUCT_ITEM = 1

class ProductsRecyclerAdapter(
    private var productList: ArrayList<ProductItemModel>,
    private val productHandler: ProductListHandler
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class HeaderViewHolder(val binding: ProductHeaderItemViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    inner class ProductViewHolder(val binding: ProductItemViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        if (viewType == HEADER_ITEM)
            HeaderViewHolder(
                ProductHeaderItemViewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        else
            ProductViewHolder(
                ProductItemViewBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        if (holder is HeaderViewHolder) {
            holder.binding.productHeader.text = productList[position].category
        } else if(holder is ProductViewHolder){
            holder.binding.apply {
                productItemTitle.text = productList[position].title
                productItemPrice.text = "${productList[position].price} EGP"
                Glide.with(root.context).load(productList[position].image).into(productItemImage)
                root.setOnClickListener {
                    productHandler.onProductClicked(productList[position])
                }
                productAddToCart.setOnClickListener {
                    productHandler.onAddProductToCart(productList[position])
                }
            }
        }
    }

    fun addProducts(products: ArrayList<ProductItemModel>) {
        productList = products
        notifyDataSetChanged()
    }

    override fun getItemCount() =
        productList.size

    override fun getItemViewType(position: Int): Int {
        return if (productList[position].isHeader)
            HEADER_ITEM
        else
            PRODUCT_ITEM
    }
}