package com.vkcup.categoriesapplication.repo.categories.api

import com.vkcup.categoriesapplication.models.Category

interface CategoriesApi {

    fun getCategories(): List<Category>
}
