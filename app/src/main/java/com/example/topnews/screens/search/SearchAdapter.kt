package com.example.topnews.screens.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import base.BasePagedListAdapter
import com.example.topnews.R
import com.example.topnews.data.db.Article
import com.example.topnews.utils.Constants.articleDiffCallback

class SearchAdapter : BasePagedListAdapter<Article>(articleDiffCallback) {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
		SearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_vertical_article, parent, false))

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		super.onBindViewHolder(holder, position)
		clickListener(holder)
	}

	private fun clickListener(holder: ViewHolder) {
		holder.itemView.setOnClickListener {
			clickListener?.invoke(getItem(holder.adapterPosition)!!)
		}
	}
}