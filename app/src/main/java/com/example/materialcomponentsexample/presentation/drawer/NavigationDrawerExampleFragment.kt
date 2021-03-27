package com.example.materialcomponentsexample.presentation.drawer

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.materialcomponentsexample.R
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar

class NavigationDrawerExampleFragment : Fragment() {

    private lateinit var rootView: View

    private lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var textPlaceholder: TextView

    private lateinit var snackbar: Snackbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = TransitionInflater.from(requireContext())
        enterTransition = inflater.inflateTransition(R.transition.fragment_fade_transition)
        exitTransition = inflater.inflateTransition(R.transition.fragment_fade_transition)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        rootView = inflater.inflate(R.layout.fragment_navigation_drawer, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initListeners()
    }

    private fun initViews() {
        textPlaceholder = rootView.findViewById(R.id.text_placeholder)
        drawerLayout = rootView.findViewById(R.id.drawer_layout)
        navigationView = rootView.findViewById(R.id.navigation_view)
        toolbar = rootView.findViewById(R.id.toolbar)
    }

    private fun initListeners() {
        toolbar.setNavigationOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navDrawerItem1 -> {
                    textPlaceholder.text =
                        requireContext().getText(R.string.placeholder_text_1)
                    textPlaceholder.setCompoundDrawablesWithIntrinsicBounds(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.ic_nav_drawer_1
                        ), null, null, null
                    )
                    showSnackBar(R.string.placeholder_text_1)
                }
                R.id.navDrawerItem2 -> {
                    textPlaceholder.text =
                        requireContext().getText(R.string.placeholder_text_2)
                    textPlaceholder.setCompoundDrawablesWithIntrinsicBounds(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.ic_nav_drawer_2
                        ), null, null, null
                    )
                    showSnackBar(R.string.placeholder_text_2)
                }
                R.id.navDrawerItem3 -> {
                    textPlaceholder.text =
                        requireContext().getText(R.string.placeholder_text_3)
                    textPlaceholder.setCompoundDrawablesWithIntrinsicBounds(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.ic_nav_drawer_3
                        ), null, null, null
                    )
                    showSnackBar(R.string.placeholder_text_3)
                }
                else -> {
                    drawerLayout.closeDrawer(GravityCompat.START)
                    return@setNavigationItemSelectedListener false
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    private fun showSnackBar(@StringRes string: Int) {
        snackbar =
            Snackbar.make(rootView, requireContext().getText(string), Snackbar.LENGTH_SHORT)
                .setAction(android.R.string.ok, View.OnClickListener {
                    snackbar.dismiss()
                })
        snackbar.show()
    }
}