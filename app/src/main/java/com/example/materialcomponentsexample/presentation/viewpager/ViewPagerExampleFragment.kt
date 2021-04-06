package com.example.materialcomponentsexample.presentation.viewpager

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.materialcomponentsexample.R
import com.example.materialcomponentsexample.presentation.viewpager.pager.ViewPagerAdapterExample
import com.google.android.material.tabs.TabLayout

class ViewPagerExampleFragment : Fragment(R.layout.fragment_view_pager) {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
    }

    private fun initViews(view: View) {
        tabLayout = view.findViewById(R.id.tabLayout)
        viewPager = view.findViewById(R.id.viewPager)

        val adapter = ViewPagerAdapterExample(childFragmentManager, requireContext())
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }
}