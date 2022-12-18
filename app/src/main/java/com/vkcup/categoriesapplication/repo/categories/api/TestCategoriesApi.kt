package com.vkcup.categoriesapplication.repo.categories.api

import com.vkcup.categoriesapplication.models.Category

class TestCategoriesApi : CategoriesApi {

    override fun getCategories() = listOf(
        Category(
            "Покупки",
            false
        ),
        Category(
            "Юмор",
            false
        ),
        Category(
            "Фильмы",
            false
        ),
        Category(
            "Еда",
            false
        ),
        Category(
            "Работа",
            false
        ),
        Category(
            "Прогулки",
            false
        ),
        Category(
            "Сериалы",
            false
        ),
        Category(
            "Автомобили",
            false
        ),
        Category(
            "Политика",
            false
        ),
        Category(
            "Рестораны",
            false
        ),
        Category(
            "Игры",
            false
        ),
        Category(
            "Комиксы",
            false
        ),
        Category(
            "Технологии",
            false
        ),
        Category(
            "Аниме",
            false
        ),
        Category(
            "Спорт",
            false
        ),
        Category(
            "Театры",
            false
        ),
        Category(
            "Музеи",
            false
        )
    )
}
