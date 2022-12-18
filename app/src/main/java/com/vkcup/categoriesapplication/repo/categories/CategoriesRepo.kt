package com.vkcup.categoriesapplication.repo.categories

import com.vkcup.categoriesapplication.models.Category
import com.vkcup.categoriesapplication.repo.categories.api.CategoriesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class CategoriesRepo(
    private val categoriesApi: CategoriesApi
) {

    fun observeCategories(): Flow<List<Category>> = flowOf(categoriesApi.getCategories())
}