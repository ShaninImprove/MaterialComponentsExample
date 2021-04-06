package com.example.materialcomponentsexample.presentation.viewpager.pager

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.materialcomponentsexample.R

class ViewPagerAdapterExample(
    fragmentManager: FragmentManager,
    private val context: Context
) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int = PAGE_COUNT

    override fun getItem(position: Int): Fragment {

        return when (position) {
            0 -> ExamplePageFragment.newInstance(
                context.getString(R.string.page_number_one),
                "https://i.playground.ru/p/K-aeC_b6_8u2cawmwJdg3g.jpeg"
            )
            1 -> ExamplePageFragment.newInstance(
                context.getString(R.string.page_number_two),
                "https://im.kommersant.ru/Issues.photo/RADIO/2021/03/29/KMO_111307_35715_1_t218_130805.jpg"
            )
            2 -> ExamplePageFragment.newInstance(
                context.getString(R.string.page_number_three),
                "https://www.meme-arsenal.com/memes/15ac92144f0ec54f147b2c32150c1d50.jpg"
            )
            else -> throw ArrayIndexOutOfBoundsException()
        }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> context.getString(R.string.tab_one)
            1 -> context.getString(R.string.tab_two)
            2 -> context.getString(R.string.tab_three)
            else -> throw ArrayIndexOutOfBoundsException()
        }
    }

    companion object {
        private const val PAGE_COUNT = 3
    }
}