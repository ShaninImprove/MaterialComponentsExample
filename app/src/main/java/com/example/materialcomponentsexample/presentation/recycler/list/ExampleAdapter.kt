package com.example.materialcomponentsexample.presentation.recycler.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.materialcomponentsexample.R
import com.example.materialcomponentsexample.data.ExampleBigItem
import com.example.materialcomponentsexample.data.ExampleItem
import com.example.materialcomponentsexample.data.ExampleSmallItem

class ExampleAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val itemList = ArrayList<ExampleItem>()
    private lateinit var onClick:(title: String) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            SMALL_ITEM -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_example_small, parent, false)
                ExampleSmallViewHolder(view, onClick)
            }
            BIG_ITEM -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_example_big, parent, false)
                ExampleBigViewHolder(view)
            }
            else -> throw ClassNotFoundException()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val currentItem = itemList[position]) {
            is ExampleSmallItem -> (holder as ExampleSmallViewHolder).bind(currentItem)
            is ExampleBigItem -> (holder as ExampleBigViewHolder).bind(currentItem)
        }
    }

    override fun getItemCount(): Int = itemList.count()

    override fun getItemViewType(position: Int): Int {
        return when (itemList[position]) {
            is ExampleSmallItem -> SMALL_ITEM
            is ExampleBigItem -> BIG_ITEM
        }
    }

    fun addItemToList(item: ExampleItem) {
        itemList.add(item)
        notifyItemChanged(itemList.count() - 1)
    }

    fun setOnclickListener(onClick:(title: String) -> Unit) {
        this.onClick = onClick
    }

    companion object {
        private const val SMALL_ITEM = 0
        private const val BIG_ITEM = 1
    }
}