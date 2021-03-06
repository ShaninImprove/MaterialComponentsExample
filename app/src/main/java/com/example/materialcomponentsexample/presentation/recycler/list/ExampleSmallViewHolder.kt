package com.example.materialcomponentsexample.presentation.recycler.list

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.materialcomponentsexample.R
import com.example.materialcomponentsexample.data.ExampleSmallItem

class ExampleSmallViewHolder(
    itemView: View,
    private val onClick:(title: String) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    private lateinit var textTitle: TextView

    fun bind(item: ExampleSmallItem) {
        textTitle = itemView.findViewById(R.id.text_view_title)
        textTitle.text = item.title
        textTitle.setCompoundDrawablesWithIntrinsicBounds(
            ContextCompat.getDrawable(itemView.context, item.icon),
            null,
            null,
            null)

        itemView.setOnClickListener {
            onClick(item.title)
        }
    }
}