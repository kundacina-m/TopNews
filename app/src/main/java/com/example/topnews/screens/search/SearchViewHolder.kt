package com.example.topnews.screens.search

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import base.BasePagedListAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.topnews.data.db.Article
import kotlinx.android.synthetic.main.item_vertical_article.view.*

class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
										 BasePagedListAdapter.ViewHolderAdapterBinder<Article> {

	override fun bind(dataItem: Article) {

		itemView.apply {
			tvTitle.text = dataItem.title
			tvSource.text = dataItem.source
			tvPublishTime.text = dataItem.publishedAt.toString()
		}
		Glide.with(itemView.context).load(dataItem.urlToImage).apply(RequestOptions().override(400, 600))
			.into(itemView.ivImg)
	}
}