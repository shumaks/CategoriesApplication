package com.vkcup.categoriesapplication.screens.categories

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.vkcup.categoriesapplication.repo.categories.CategoriesRepo
import com.vkcup.categoriesapplication.repo.categories.api.TestCategoriesApi
import com.vkcup.categoriesapplication.screens.categories.ui.CategoriesScreenView

class CategoriesActivity : AppCompatActivity() {

    private val api = TestCategoriesApi()
    private val repo = CategoriesRepo(api)
    private val viewModel = CategoriesViewModel(repo)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        setContent {
            CategoriesScreenView(viewModel)
        }
    }
}
