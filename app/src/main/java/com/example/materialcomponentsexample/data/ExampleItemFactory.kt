package com.example.materialcomponentsexample.data

import com.example.materialcomponentsexample.R
import kotlin.random.Random

class ExampleItemFactory {

    companion object {
        fun createSmallItem(): ExampleSmallItem {
            return ExampleSmallItem(
                getRandomString(),
                getRandomIcon()
            )
        }

        fun createBigItem(): ExampleBigItem {
            return ExampleBigItem(
                getRandomString(),
                getRandomString(),
                getRandomIcon()
            )
        }

        private fun getRandomIcon(): Int {
            return icons[Random.nextInt(0, icons.size)]
        }

        private fun getRandomString(): String {
            return strings[Random.nextInt(0, strings.size)]
        }

        private val icons = arrayListOf(
            R.drawable.ic_nav_drawer_1,
            R.drawable.ic_nav_drawer_2,
            R.drawable.ic_nav_drawer_3,
            R.drawable.ic_lines,
            R.drawable.ic_baseline_add,
            R.drawable.ic_navigation_drawer,
            R.drawable.ic_recycler_view,
        )

        private val strings = arrayListOf(
            "RecyclerView makes it easy to efficiently display large sets of data.",
            "You supply the data and define how each item looks",
            "As the name implies, RecyclerView recycles those individual elements.",
            "RecyclerView reuses the view for new items that have scrolled onscreen.",
            "Each individual element in the list is defined by a view holder object.",
            "After the view holder is created, the RecyclerView binds it to its data.",
            "The layout manager arranges the individual elements in your list.",
            "If you're going to use RecyclerView, there are a few things you need to do."
        )
    }
}