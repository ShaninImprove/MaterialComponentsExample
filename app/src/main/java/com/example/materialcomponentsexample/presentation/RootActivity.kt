package com.example.materialcomponentsexample.presentation

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.materialcomponentsexample.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class RootActivity : AppCompatActivity() {

    private lateinit var fragmentContainer: FrameLayout
    private lateinit var bottomBar: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_root)

        initViews()
        initListeners()
        openScreen(FragmentScreenFactory.Screen.NAVIGATION_DRAWER_SCREEN)
    }

    private fun initViews() {
        fragmentContainer = findViewById(R.id.layout_fragment_container)
        bottomBar = findViewById(R.id.bottom_navigation)
    }

    private fun initListeners() {
        bottomBar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navDrawerScreen -> openScreen(FragmentScreenFactory.Screen.NAVIGATION_DRAWER_SCREEN)
                R.id.recyclerViewScreen -> openScreen(FragmentScreenFactory.Screen.RECYCLER_VIEW_SCREEN)
                else -> return@setOnNavigationItemSelectedListener false
            }
            true
        }
    }

    private fun openScreen(screen: FragmentScreenFactory.Screen) {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.layout_fragment_container,
                FragmentScreenFactory.getScreenInstance(screen)
            )
            .commit()
    }
}