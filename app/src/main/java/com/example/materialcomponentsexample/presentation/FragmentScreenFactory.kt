package com.example.materialcomponentsexample.presentation

import androidx.fragment.app.Fragment
import com.example.materialcomponentsexample.presentation.drawer.NavigationDrawerExampleFragment
import com.example.materialcomponentsexample.presentation.recycler.RecyclerViewExampleFragment

class FragmentScreenFactory {

    companion object {

        fun getScreenInstance(screen: Screen): Fragment = when (screen) {
            Screen.NAVIGATION_DRAWER_SCREEN -> NavigationDrawerExampleFragment()
            Screen.RECYCLER_VIEW_SCREEN -> RecyclerViewExampleFragment()
        }
    }

    enum class Screen {
        NAVIGATION_DRAWER_SCREEN,
        RECYCLER_VIEW_SCREEN
    }
}