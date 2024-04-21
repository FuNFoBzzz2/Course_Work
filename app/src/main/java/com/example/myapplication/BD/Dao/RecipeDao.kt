package com.example.myapplication.BD.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.BD.Recipe

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRecipe(Recipe: Recipe)

    @Query("Select * from Recipe")
    fun getAllRecipe(): LiveData<List<Recipe>>

    @Delete
    suspend fun deleteRecipe(Recipe: Recipe)

    @Update
    suspend fun updateRecipe(Recipe: Recipe)
}