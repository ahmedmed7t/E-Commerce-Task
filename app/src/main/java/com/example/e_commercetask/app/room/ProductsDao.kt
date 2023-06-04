package com.example.e_commercetask.app.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.e_commercetask.productsList.data.models.ProductItemModel

@Dao
interface ProductsDao {

    @Insert
    suspend fun insert(product: ProductItemModel)

    @Update
    suspend fun update(product: ProductItemModel)

    @Query("SELECT * FROM Products")
    suspend fun getUAllProducts(): List<ProductItemModel>

    @Query("SELECT * FROM Products WHERE id = :productId")
    suspend fun getProductById(productId: Int): ProductItemModel?
}