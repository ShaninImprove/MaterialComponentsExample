package com.example.materialcomponentsexample.presentation.viewpager.pager

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.materialcomponentsexample.R

class ExamplePageFragment private constructor(): Fragment(R.layout.fragment_page_example) {

    private lateinit var imageView: ImageView
    private lateinit var textView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews(view)
        fillViewData()
    }

    private fun initViews(view: View) {
        imageView = view.findViewById(R.id.imageView_picture)
        textView = view.findViewById(R.id.textView_title)
    }

    private fun fillViewData() {
        textView.text = arguments?.getString(TITLE_TEXT_ARG)
        Glide.with(this)
            .load(arguments?.getString(IMAGE_URL_ARG))
            .placeholder(R.drawable.smile)
            .into(imageView)
    }

    companion object {
        private const val TITLE_TEXT_ARG = "ExamplePageFragment.TITLE_TEXT_ARG"
        private const val IMAGE_URL_ARG = "ExamplePageFragment.IMAGE_URL_ARG"

        fun newInstance(title: String, imageUrl: String): ExamplePageFragment {
            val args = Bundle()
            args.putString(TITLE_TEXT_ARG, title)
            args.putString(IMAGE_URL_ARG, imageUrl)

            val fragment = ExamplePageFragment()
            fragment.arguments = args
            return fragment
        }
    }
}