package com.example.topnews.screens.topnews

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.topnews.screens.Article
import base.BaseAdapter
import base.BaseViewHolder
import kotlinx.android.synthetic.main.item_top_news.view.*

class TopNewsViewHolder(itemView: View) : BaseViewHolder<Article>(itemView){

    override fun bind(dataItem: Article) {
        itemView.tvArticleTitle.text = dataItem.title
        Glide.with(itemView.context).load(dataItem.imageUrl).apply(RequestOptions().override(400, 600))
            .into(itemView.ivArticleImage)
    }
}