package com.example.topnews.screens.topnews


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.GridLayoutManager
import com.example.topnews.R
import com.example.topnews.screens.dummyDataForTopNews
import com.example.topnews.screens.fakeData
import kotlinx.android.synthetic.main.fragment_top_news.*
import androidx.recyclerview.widget.RecyclerView


class TopNewsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_top_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupLayoutManager()

    }

    private fun setupLayoutManager() {
        val layoutManager = GridLayoutManager(context, 2)
        topNewsRecyclerView.layoutManager = layoutManager

        topNewsRecyclerView.adapter = setupAdapter()
    }

    private fun setupAdapter(): TopNewsAdapter {
        val adapter = TopNewsAdapter(context!!)
        adapter.setData(fakeData.fakeData)

        return adapter
    }

}
