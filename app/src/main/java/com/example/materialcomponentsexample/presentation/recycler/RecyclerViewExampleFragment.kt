package com.example.materialcomponentsexample.presentation.recycler

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.materialcomponentsexample.R
import com.example.materialcomponentsexample.data.ExampleItemFactory
import com.example.materialcomponentsexample.presentation.recycler.list.ExampleAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RecyclerViewExampleFragment : Fragment() {

    private lateinit var rootView: View

    private lateinit var recyclerView: RecyclerView
    private lateinit var addFab: FloatingActionButton
    private lateinit var addBigItemFab: FloatingActionButton
    private lateinit var toolbar: Toolbar
    private lateinit var emptyImage: ImageView
    private lateinit var textPlaceholder: TextView

    private val adapter = ExampleAdapter()

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
        rootView = inflater.inflate(R.layout.fragment_recycler_view, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initListeners()
    }

    private fun initViews() {
        toolbar = rootView.findViewById(R.id.toolbar)
        toolbar.inflateMenu(R.menu.menu_recycler_layout)
        recyclerView = rootView.findViewById(R.id.recycler_view)
        addFab = rootView.findViewById(R.id.fab_add)
        addBigItemFab = rootView.findViewById(R.id.fab_add_big_element)
        addBigItemFab.hide()
        initRecycler()
        emptyImage = rootView.findViewById(R.id.imageView)
        textPlaceholder = rootView.findViewById(R.id.text_placeholder)
    }

    private fun initListeners() {
        addFab.setOnLongClickListener {
            if (addBigItemFab.isShown) {
                addBigItemFab.hide()
            } else {
                addBigItemFab.show()
            }
            true
        }
        addFab.setOnClickListener {
            adapter.addItemToList(ExampleItemFactory.createSmallItem())
            checkEmptyState()
        }
        addBigItemFab.setOnClickListener {
            adapter.addItemToList(ExampleItemFactory.createBigItem())
            checkEmptyState()
        }
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.linear_layout -> setLinearLayout()
                R.id.grid_layout -> setGridLayout()
            }
            true
        }
    }

    private fun initRecycler() {
        setLinearLayout()
        recyclerView.adapter = adapter
        adapter.setOnclickListener {
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        }
    }

    private fun setLinearLayout() {
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    private fun setGridLayout() {
        recyclerView.layoutManager =
           StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
//           StaggeredGridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
    }

    private fun checkEmptyState() {
        val needToShowEmptyState = adapter.itemCount == 0
        emptyImage.isVisible = needToShowEmptyState
        textPlaceholder.isVisible = needToShowEmptyState
    }
}