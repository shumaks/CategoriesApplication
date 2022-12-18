package com.vkcup.categoriesapplication.screens.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vkcup.categoriesapplication.models.Category
import com.vkcup.categoriesapplication.repo.categories.CategoriesRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CategoriesViewModel(
    private val categoriesRepo: CategoriesRepo
) :  ViewModel() {
    val categoriesListStateFlow = MutableStateFlow<List<Category>>(emptyList())

    fun getCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            categoriesRepo.observeCategories().collect {
                categoriesListStateFlow.value = it
            }
        }
    }

    fun selectCategory(category: Category) {
        categoriesListStateFlow.value = categoriesListStateFlow.value.map {
            if (it == category) {
                category.copy(isSelected = !it.isSelected)
            } else {
                it
            }
        }
    }

    fun continueWithCategories() {
        val selectedCategories = categoriesListStateFlow.value.filter { it.isSelected }
        /*
            do anything with selected categories
        */
    }

    fun goToNextScreen() { /* navigate to another screen */ }
}
