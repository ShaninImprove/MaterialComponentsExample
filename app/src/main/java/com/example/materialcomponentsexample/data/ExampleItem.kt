package com.example.materialcomponentsexample.data

import androidx.annotation.DrawableRes

sealed class ExampleItem

data class ExampleSmallItem(
    val title: String,
    @DrawableRes val icon: Int
) : ExampleItem()

data class ExampleBigItem(
    val title: String,
    val subtitle: String,
    @DrawableRes val icon: Int
): ExampleItem()