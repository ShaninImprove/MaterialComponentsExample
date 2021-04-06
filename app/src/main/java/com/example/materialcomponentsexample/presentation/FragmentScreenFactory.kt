package com.example.materialcomponentsexample.presentation

import androidx.fragment.app.Fragment
import com.example.materialcomponentsexample.presentation.drawer.NavigationDrawerExampleFragment
import com.example.materialcomponentsexample.presentation.recycler.RecyclerViewExampleFragment
import com.example.materialcomponentsexample.presentation.viewpager.ViewPagerExampleFragment

class FragmentScreenFactory {

    companion object {

        fun getScreenInstance(screen: Screen): Fragment = when (screen) {
            Screen.NAVIGATION_DRAWER_SCREEN -> NavigationDrawerExampleFragment()
            Screen.RECYCLER_VIEW_SCREEN -> RecyclerViewExampleFragment()
            Screen.VIEW_PAGER_SCREEN -> ViewPagerExampleFragment()
        }
    }

    enum class Screen {
        NAVIGATION_DRAWER_SCREEN,
        RECYCLER_VIEW_SCREEN,
        VIEW_PAGER_SCREEN
    }
}