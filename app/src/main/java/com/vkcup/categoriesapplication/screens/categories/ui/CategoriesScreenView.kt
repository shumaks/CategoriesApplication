package com.vkcup.categoriesapplication.screens.categories.ui

import android.annotation.SuppressLint
import androidx.compose.animation.Animatable
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.vkcup.categoriesapplication.R
import com.vkcup.categoriesapplication.models.Category
import com.vkcup.categoriesapplication.screens.categories.CategoriesViewModel

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("RememberReturnType")
@Composable
fun CategoriesScreenView(viewModel: CategoriesViewModel) {
    viewModel.getCategories()

    MaterialTheme {
        Box(
            modifier = Modifier.background(Color.Black).fillMaxSize()
        ) {
            val categories = viewModel.categoriesListStateFlow.collectAsState().value

            Column(
                modifier = Modifier
                    .padding(
                        top = CategoriesScreenTopPadding,
                        start = CategoriesScreenStartEndPadding,
                        end = CategoriesScreenStartEndPadding
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                HeaderView(viewModel)

                LazyHorizontalStaggeredGrid(
                    rows = StaggeredGridCells.Adaptive(minSize = CategoriesStaggeredGridMinSize),
                    horizontalArrangement = Arrangement.spacedBy(CategoriesStaggeredGridArrangement),
                    modifier = Modifier
                        .height(CategoriesStaggeredGridHeight)
                        .fillMaxWidth()
                ) {
                    items(categories) { item ->
                        ItemView(item, viewModel)
                    }
                }

                if (categories.any { it.isSelected }) {
                    ButtonContinue(viewModel)
                }
            }
        }
    }
}

@Composable
fun HeaderView(viewModel: CategoriesViewModel) {
    Row {
        Text(
            text = stringResource(R.string.header_text),
            fontSize = CategoriesTextSize,
            color = Color(LIGHT_GREY_COLOR),
            modifier = Modifier
                .width(HeaderWidth)
                .height(HeaderHeight),
            textAlign = TextAlign.Start
        )

        Button(
            onClick = { viewModel.goToNextScreen() },
            colors = ButtonDefaults.buttonColors(Color(GREY_COLOR))
        ) {
            Text(
                text = stringResource(R.string.header_button_title),
                fontSize = CategoriesTextSize,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun ItemView(item: Category, viewModel: CategoriesViewModel) {
    val color = remember { Animatable(Color(BLACK_COLOR)) }
    LaunchedEffect(item.isSelected) {
        color.animateTo(if (item.isSelected) Color(RED_COLOR) else Color(BLACK_COLOR))
    }
    val icon = if (!item.isSelected) {
        PLUS_ICON
    } else {
        DONE_ICON
    }

    Button(
        onClick = { viewModel.selectCategory(item) },
        colors = ButtonDefaults.buttonColors(color.value),
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
    ) {
        Text(
            text = "${item.name} | $icon",
            fontSize = CategoriesTextSize,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ButtonContinue(viewModel: CategoriesViewModel) {
    Button(
        onClick = { viewModel.continueWithCategories() },
        colors = ButtonDefaults.buttonColors(Color.White),
        modifier = Modifier
            .width(ContinueButtonWidth)
            .height(ContinueButtonHeight)
            .padding(ContinueButtonPadding),
    ) {
        Text(
            text = stringResource(R.string.button_continue_title),
            fontSize = ContinuesButtonTextSize,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    }
}
