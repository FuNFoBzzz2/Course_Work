package com.example.myapplication.BD.Repository

import androidx.lifecycle.LiveData
import com.example.myapplication.BD.Recipe
import com.example.myapplication.BD.Dao.RecipeDao

class RepositoryRecipe(private var dao: RecipeDao) {
    val readAllData: LiveData<List<Recipe>> = dao.getAllRecipe()

    suspend fun deleteRecipe(Recipe: Recipe){
        dao.deleteRecipe(Recipe)
    }

    suspend fun insertRecipe(Recipe: Recipe){
        dao.insertRecipe(Recipe)
    }
    suspend fun updateRecipe(Recipe: Recipe){
        dao.updateRecipe(Recipe)
    }
}