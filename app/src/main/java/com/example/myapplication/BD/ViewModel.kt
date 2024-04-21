package com.example.myapplication.BD

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.BD.Repository.RepositoryRecipe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(application: Application): AndroidViewModel(application) {
    var readAllRecipe: LiveData<List<Recipe>> = MutableLiveData<List<Recipe>>()
    private val RepositoryRecipe: RepositoryRecipe
    init {
        val Dao = DataBase.getDatabase(application).RecipeDao()
        RepositoryRecipe = RepositoryRecipe(Dao)
    }
     fun addRecipe(Recipe: Recipe){
         viewModelScope.launch(Dispatchers.IO) {
             RepositoryRecipe.insertRecipe(Recipe)
         }
     }
    fun DeleteRecipe(Recipe: Recipe){
        viewModelScope.launch(Dispatchers.IO) {
            RepositoryRecipe.deleteRecipe(Recipe)
        }
    }
    fun UpdateRecipe(Recipe: Recipe){
        viewModelScope.launch(Dispatchers.IO) {
            RepositoryRecipe.updateRecipe(Recipe)
        }
    }
}