package com.example.e_commercetask.productsList.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductItemModel(
    val category: String = "",
    val description: String = "",
    val id: Int = 0,
    val image: String = "",
    val price: String = "",
    val title: String = "",
    val isHeader: Boolean = false
) : Parcelable