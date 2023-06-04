package com.example.e_commercetask.productsList.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Entity(tableName = "Products")
@Parcelize
data class ProductItemModel(
    @PrimaryKey val id: Int = 0,
    val category: String = "",
    val description: String = "",
    val image: String = "",
    val price: String = "",
    val title: String = "",
    val quantity: Int = 0,
    val isHeader: Boolean = false
) : Parcelable