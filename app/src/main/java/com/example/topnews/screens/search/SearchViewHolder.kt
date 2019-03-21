package com.example.topnews.screens.search

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.topnews.screens.Article
import base.BaseViewHolder
import kotlinx.android.synthetic.main.item_search_result.view.*

class SearchViewHolder(itemView: View) : BaseViewHolder<Article>(itemView) {

    override fun bind(dataItem: Article) {
        itemView.apply {
            tvTitle.text = dataItem.title
            tvSource.text = dataItem.source.getValue("name")
            tvPublishTime.text = dataItem.publishedAt
        }
        Glide.with(itemView.context).load(dataItem.imageUrl).apply(RequestOptions().override(400, 600))
            .into(itemView.ivImg)
    }
}