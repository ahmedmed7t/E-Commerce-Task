package com.example.e_commercetask.app.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.e_commercetask.productsList.data.models.ProductItemModel

@Database(entities = [ProductItemModel::class], version = 1)
abstract class ProductsDataBase : RoomDatabase(){
    abstract fun productsDao(): ProductsDao
}